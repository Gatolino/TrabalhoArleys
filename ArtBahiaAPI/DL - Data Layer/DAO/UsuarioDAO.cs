using ArtBahiaAPI.Models;
using Dapper;
using Microsoft.Extensions.Configuration;
using System.Linq;

namespace ArtBahiaAPI.DAO {

	public class UsuarioDAO : GenericDAO<UsuarioDTO> {

		public UsuarioDAO(IConfiguration config) : base(config) { }

		public UsuarioDTO Login(UsuarioDTO usuario) {
			using (Connection) {
				var result = Connection.Query<UsuarioDTO>($"SELECT * FROM Usuario WHERE Login = '{usuario.Login}' AND Senha = '{usuario.Senha}'");
				return result.Count() == 1 ? result.First() : null;
			}
		}
	}
}
