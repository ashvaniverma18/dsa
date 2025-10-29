from __future__ import annotations

from datetime import date, datetime
from decimal import Decimal, InvalidOperation
from typing import Optional

from flask import (
    Blueprint,
    flash,
    redirect,
    render_template,
    request,
    url_for,
)
from sqlalchemy import select

from .models import db, Category, Expense, Reports


main_blueprint = Blueprint("main", __name__)


# ---------- Helpers ----------

def _parse_decimal(value: str) -> Decimal:
    try:
        return Decimal(value)
    except (InvalidOperation, TypeError):
        raise ValueError("Invalid amount")


def _parse_date(value: str) -> date:
    try:
        return datetime.strptime(value, "%Y-%m-%d").date()
    except Exception:  # noqa: BLE001 - user input validation
        raise ValueError("Invalid date; expected YYYY-MM-DD")


# ---------- Routes ----------


@main_blueprint.route("/expenses")
def expenses():
    category_id = request.args.get("category", type=int)
    start = request.args.get("start")
    end = request.args.get("end")

    query = Expense.query
    if category_id:
        query = query.filter(Expense.category_id == category_id)
    if start:
        query = query.filter(Expense.date >= _parse_date(start))
    if end:
        query = query.filter(Expense.date <= _parse_date(end))

    expenses_list = query.order_by(Expense.date.desc(), Expense.id.desc()).all()
    total = sum(e.amount for e in expenses_list) if expenses_list else Decimal("0.00")

    categories = Category.query.order_by(Category.name.asc()).all()
    return render_template(
        "expenses.html",
        expenses=expenses_list,
        total=total,
        categories=categories,
        selected_category=category_id,
        start=start,
        end=end,
    )


@main_blueprint.route("/expenses/new", methods=["GET", "POST"])
def expense_new():
    categories = Category.query.order_by(Category.name.asc()).all()
    if request.method == "POST":
        description = (request.form.get("description") or "").strip()
        amount_raw = request.form.get("amount")
        date_raw = request.form.get("date")
        category_id = request.form.get("category_id", type=int)

        errors = []
        if not description:
            errors.append("Description is required")
        try:
            amount = _parse_decimal(amount_raw)
        except ValueError as e:  # noqa: F841 - show in UI
            errors.append("Valid amount is required")
            amount = Decimal("0.00")
        try:
            expense_date = _parse_date(date_raw)
        except ValueError:
            errors.append("Valid date is required")
            expense_date = date.today()

        if errors:
            for msg in errors:
                flash(msg, "error")
            return render_template(
                "expense_form.html",
                categories=categories,
                form={
                    "description": description,
                    "amount": amount_raw,
                    "date": date_raw,
                    "category_id": category_id,
                },
                action_url=url_for("main.expense_new"),
                heading="Add Expense",
            )

        new_expense = Expense(
            description=description,
            amount=amount,
            date=expense_date,
            category_id=category_id or None,
        )
        db.session.add(new_expense)
        db.session.commit()
        flash("Expense added", "success")
        return redirect(url_for("main.expenses"))

    # GET
    return render_template(
        "expense_form.html",
        categories=categories,
        form={"date": date.today().strftime("%Y-%m-%d")},
        action_url=url_for("main.expense_new"),
        heading="Add Expense",
    )


@main_blueprint.route("/expenses/<int:expense_id>/edit", methods=["GET", "POST"])
def expense_edit(expense_id: int):
    expense = Expense.query.get_or_404(expense_id)
    categories = Category.query.order_by(Category.name.asc()).all()

    if request.method == "POST":
        description = (request.form.get("description") or "").strip()
        amount_raw = request.form.get("amount")
        date_raw = request.form.get("date")
        category_id = request.form.get("category_id", type=int)

        errors = []
        if not description:
            errors.append("Description is required")
        try:
            amount = _parse_decimal(amount_raw)
        except ValueError:
            errors.append("Valid amount is required")
            amount = expense.amount
        try:
            expense_date = _parse_date(date_raw)
        except ValueError:
            errors.append("Valid date is required")
            expense_date = expense.date

        if errors:
            for msg in errors:
                flash(msg, "error")
            return render_template(
                "expense_form.html",
                categories=categories,
                form={
                    "description": description or expense.description,
                    "amount": amount_raw or str(expense.amount),
                    "date": date_raw or expense.date.strftime("%Y-%m-%d"),
                    "category_id": category_id or expense.category_id,
                },
                action_url=url_for("main.expense_edit", expense_id=expense.id),
                heading="Edit Expense",
            )

        expense.description = description
        expense.amount = amount
        expense.date = expense_date
        expense.category_id = category_id or None
        db.session.commit()
        flash("Expense updated", "success")
        return redirect(url_for("main.expenses"))

    # GET
    return render_template(
        "expense_form.html",
        categories=categories,
        form={
            "description": expense.description,
            "amount": str(expense.amount),
            "date": expense.date.strftime("%Y-%m-%d"),
            "category_id": expense.category_id,
        },
        action_url=url_for("main.expense_edit", expense_id=expense.id),
        heading="Edit Expense",
    )


@main_blueprint.route("/expenses/<int:expense_id>/delete", methods=["POST"])
def expense_delete(expense_id: int):
    expense = Expense.query.get_or_404(expense_id)
    db.session.delete(expense)
    db.session.commit()
    flash("Expense deleted", "success")
    return redirect(url_for("main.expenses"))


@main_blueprint.route("/categories", methods=["GET", "POST"])
def categories():
    if request.method == "POST":
        name = (request.form.get("name") or "").strip()
        if not name:
            flash("Category name is required", "error")
        elif db.session.scalar(select(Category).where(Category.name == name)):
            flash("Category already exists", "error")
        else:
            db.session.add(Category(name=name))
            db.session.commit()
            flash("Category added", "success")
        return redirect(url_for("main.categories"))

    categories_list = Category.query.order_by(Category.name.asc()).all()
    return render_template("categories.html", categories=categories_list)


@main_blueprint.route("/categories/<int:category_id>/delete", methods=["POST"])
def category_delete(category_id: int):
    category = Category.query.get_or_404(category_id)

    # Prevent accidental deletion if in use
    has_expenses = db.session.scalar(
        select(db.func.count()).select_from(Expense).where(Expense.category_id == category.id)
    )
    if has_expenses:
        flash("Cannot delete category with existing expenses", "error")
        return redirect(url_for("main.categories"))

    db.session.delete(category)
    db.session.commit()
    flash("Category deleted", "success")
    return redirect(url_for("main.categories"))


@main_blueprint.route("/reports")
def reports():
    monthly = Reports.monthly_totals()
    return render_template("reports.html", monthly=monthly)
