from __future__ import annotations

from datetime import datetime, date
from decimal import Decimal

from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import Numeric, ForeignKey, func
from sqlalchemy.orm import Mapped, mapped_column, relationship


db = SQLAlchemy()


class Category(db.Model):
    __tablename__ = "categories"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(db.String(100), unique=True, nullable=False)
    created_at: Mapped[datetime] = mapped_column(
        db.DateTime, default=datetime.utcnow, nullable=False
    )

    expenses: Mapped[list[Expense]] = relationship("Expense", back_populates="category")

    def __repr__(self) -> str:  # pragma: no cover - debug helper
        return f"<Category id={self.id} name={self.name!r}>"


class Expense(db.Model):
    __tablename__ = "expenses"

    id: Mapped[int] = mapped_column(primary_key=True)
    description: Mapped[str] = mapped_column(db.String(255), nullable=False)
    amount: Mapped[Decimal] = mapped_column(Numeric(10, 2), nullable=False)
    date: Mapped[date] = mapped_column(db.Date, nullable=False, index=True)

    category_id: Mapped[int | None] = mapped_column(ForeignKey("categories.id"))
    category: Mapped[Category | None] = relationship("Category", back_populates="expenses")

    created_at: Mapped[datetime] = mapped_column(
        db.DateTime, default=datetime.utcnow, nullable=False
    )

    def __repr__(self) -> str:  # pragma: no cover - debug helper
        return f"<Expense id={self.id} amount={self.amount} date={self.date} desc={self.description!r}>"


# Simple query helpers for reporting
class Reports:
    @staticmethod
    def monthly_totals():
        """Return list of (YYYY-MM, total_amount) rows ordered by month desc."""
        month_col = func.strftime("%Y-%m", Expense.date).label("month")
        total_col = func.sum(Expense.amount).label("total")
        return (
            db.session.query(month_col, total_col)
            .group_by(month_col)
            .order_by(month_col.desc())
            .all()
        )
