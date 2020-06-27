using ArtBahiaAPI.Models;
using Dapper;
using Microsoft.Extensions.Configuration;
using System.Linq;

namespace ArtBahiaAPI.DAO {

	public class ObraDAO : GenericDAO<ObraDTO> {

		public ObraDAO(IConfiguration config) : base(config) { }

		public ObraDTO Curtir(int idObra) {
			using (Connection) {
				var result = Connection.Query<ObraDTO>($"UPDATE Obra SET Curtidas = Curtidas +1 WHERE Id = {idObra}");
				return result.Count() == 1 ? result.First() : null;
			}
		}
	}
}
