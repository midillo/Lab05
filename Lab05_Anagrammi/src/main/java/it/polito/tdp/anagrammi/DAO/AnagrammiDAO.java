package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Anagrammi;

public class AnagrammiDAO {
	
	public List<Anagrammi> getDizionario(){
		
		final String sql = "SELECT * FROM parola";
		LinkedList<Anagrammi> dizionario = new LinkedList<Anagrammi>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				Anagrammi parola = new Anagrammi(rs.getInt("id"), rs.getString("nome"));
				dizionario.add(parola);
			}
			
			rs.close();
			st.close();
			conn.close();
			return dizionario;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}	
	}

		public boolean isCorrect(String anagramma) {
			
			final String sql = "SELECT nome FROM parola WHERE nome = ?";
			boolean flag;
			
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, anagramma);
				
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					flag =  true;
				} else {
					flag =  false;
				}
				
				
				rs.close();
				st.close();
				conn.close();
				return flag;
				
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}	
			
			
			
		}
}
