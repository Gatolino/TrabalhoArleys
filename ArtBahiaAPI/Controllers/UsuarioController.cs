using ArtBahiaAPI.DAO;
using ArtBahiaAPI.Models;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace ArtBahiaAPI.Controllers {

	[ApiController]
	[Route("[controller]")]
	public class UsuarioController : ControllerBase {
		private readonly UsuarioDAO usuarioDAO;

		public UsuarioController([FromServices] UsuarioDAO usuarioDAO) {
			this.usuarioDAO = usuarioDAO;
		}

		[HttpGet]
		[Route("Login/{username?}/{password?}")]
		public UsuarioDTO Login(string username, string password) {
			UsuarioDTO usuario = usuarioDAO.Login(new UsuarioDTO { Login = username, Senha = password });

			return usuario ?? new UsuarioDTO { Login = "invalid" };
		}

		// CRUD
		#region Create
		[HttpPost]
		[Route("Create/")]
		public UsuarioDTO Create(UsuarioDTO usuario) {
			try {
				usuario.Id = (int)usuarioDAO.Create(usuario);
				return usuario;
			}
			catch {
				return null;
			}
		}
		#endregion

		#region Read
		[HttpGet]
		public IEnumerable<UsuarioDTO> Get() {
			return usuarioDAO.Read();
		}
		#endregion
	}
}
