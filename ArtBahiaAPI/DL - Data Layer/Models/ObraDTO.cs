using Dapper.Contrib.Extensions;

namespace ArtBahiaAPI.Models {
	[Table("Obra")]
	public class ObraDTO {
		[Key]
		public int Id { get; set; }
		public string Titulo { get; set; }
		public int IdUsuario { get; set; }
		public int Tipo { get; set; }
		public int Curtidas { get; set; }
	}
}
