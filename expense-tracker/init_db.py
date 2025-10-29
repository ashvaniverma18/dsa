from __future__ import annotations

from datetime import date, timedelta
from decimal import Decimal

from expense_tracker.app import create_app
from expense_tracker.models import db, Category, Expense


def init_db(seed: bool = True) -> None:
    app = create_app()
    with app.app_context():
        # Tables are created in create_app; ensure again
        db.create_all()

        if not Category.query.first():
            default_categories = [
                "Groceries",
                "Transport",
                "Rent",
                "Utilities",
                "Dining",
                "Entertainment",
                "Health",
                "Misc",
            ]
            db.session.add_all([Category(name=name) for name in default_categories])
            db.session.commit()

        if seed and not Expense.query.first():
            groceries = Category.query.filter_by(name="Groceries").first()
            transport = Category.query.filter_by(name="Transport").first()
            misc = Category.query.filter_by(name="Misc").first()

            today = date.today()
            sample = [
                Expense(description="Supermarket", amount=Decimal("54.20"), date=today, category_id=groceries.id if groceries else None),
                Expense(description="Bus pass", amount=Decimal("25.00"), date=today - timedelta(days=1), category_id=transport.id if transport else None),
                Expense(description="Coffee", amount=Decimal("3.50"), date=today - timedelta(days=2), category_id=misc.id if misc else None),
            ]
            db.session.add_all(sample)
            db.session.commit()
            print("Seeded sample data.")

        print("Database initialized at:", app.config["SQLALCHEMY_DATABASE_URI"]) 


if __name__ == "__main__":
    init_db()
