import os
from flask import Flask, redirect, url_for

from .models import db
from .routes import main_blueprint


def create_app(test_config: dict | None = None) -> Flask:
    app = Flask(__name__, instance_relative_config=False)

    # Basic, safe default secret key for local dev; override via ENV in production
    app.config["SECRET_KEY"] = os.environ.get("SECRET_KEY", "dev-secret-key-change-me")

    # Store the SQLite database file alongside the package (self-contained)
    package_dir = os.path.dirname(__file__)
    db_path = os.path.join(package_dir, "expense_tracker.db")
    app.config["SQLALCHEMY_DATABASE_URI"] = os.environ.get(
        "DATABASE_URL", f"sqlite:///{db_path}"
    )
    app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

    if test_config:
        app.config.update(test_config)

    # Init extensions
    db.init_app(app)

    # Register blueprints
    app.register_blueprint(main_blueprint)

    # Ensure tables exist on startup (simple for this demo app)
    with app.app_context():
        db.create_all()

    @app.route("/")
    def index():
        return redirect(url_for("main.expenses"))

    return app
