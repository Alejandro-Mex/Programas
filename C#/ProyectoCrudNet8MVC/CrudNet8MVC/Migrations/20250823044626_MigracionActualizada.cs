using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace CrudNet8MVC.Migrations
{
    /// <inheritdoc />
    public partial class MigracionActualizada : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Apellidos",
                table: "Contacto",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "Codigo",
                table: "Contacto",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "Usuario",
                table: "Contacto",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Apellidos",
                table: "Contacto");

            migrationBuilder.DropColumn(
                name: "Codigo",
                table: "Contacto");

            migrationBuilder.DropColumn(
                name: "Usuario",
                table: "Contacto");
        }
    }
}
