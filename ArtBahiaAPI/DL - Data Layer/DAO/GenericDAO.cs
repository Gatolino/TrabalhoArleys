using Dapper.Contrib.Extensions;
using Microsoft.Extensions.Configuration;
using MySql.Data.MySqlClient;
using System.Collections.Generic;

namespace ArtBahiaAPI.DAO {
	public class GenericDAO<T> where T : class {
		protected IConfiguration configuration;
		protected MySqlConnection Connection => new MySqlConnection(configuration.GetConnectionString("BasePrincipal"));

		public GenericDAO(IConfiguration config) {
			configuration = config;
		}

		// CRUD
		#region Create
		public long Create(T dataObject) {
			using (Connection) {
				return Connection.Insert(dataObject);
			}
		}
		#endregion

		#region Read
		public T Read(int id) {
			using (Connection) {
				return Connection.Get<T>(id);
			}
		}

		public IEnumerable<T> Read() {
			using (Connection) {
				return Connection.GetAll<T>();
			}
		}
		#endregion
	}
}
