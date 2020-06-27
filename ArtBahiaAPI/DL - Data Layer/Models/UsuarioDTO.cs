using Dapper.Contrib.Extensions;

namespace ArtBahiaAPI.Models {
	[Table("Usuario")]
	public class UsuarioDTO {
		[Key]
		public int Id { get; set; }
		public string Login { get; set; }
		public string Senha { get; set; }
		public string Nome { get; set; }
		public bool IsArtista { get; set; }
	}
}
