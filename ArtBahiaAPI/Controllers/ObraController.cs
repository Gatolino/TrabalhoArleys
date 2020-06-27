using ArtBahiaAPI.DAO;
using ArtBahiaAPI.Models;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace ArtBahiaAPI.Controllers {

	[ApiController]
	[Route("[controller]")]
	public class ObraController : ControllerBase {
		private readonly ObraDAO obraDAO;

		public ObraController([FromServices] ObraDAO obraDAO) {
			this.obraDAO = obraDAO;
		}

		[HttpGet]
		[Route("Curtir/{idObra?}")]
		public ObraDTO Curtir(int idObra) {
			return obraDAO.Curtir(idObra);
		}

		// CRUD
		#region Create
		[HttpPost]
		[Route("Create/")]
		public ObraDTO Create(ObraDTO obra) {
			try {
				obra.Id = (int)obraDAO.Create(obra);
				return obra;
			}
			catch {
				return null;
			}
		}
		#endregion

		#region Read
		[HttpGet]
		public IEnumerable<ObraDTO> Get() {
			return obraDAO.Read();
		}

		[HttpGet]
		[Route("GetById/{id?}")]
		public ObraDTO GetById(int id) {
			return obraDAO.Read(id);
		}
		#endregion
	}
}
