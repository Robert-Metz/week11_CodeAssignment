package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pokemon;

public class PokemonDao {
	
	private Connection connection;
	private final String GET_POKEMON_BY_POKESET_QUERY = "SELECT * FROM pokemon WHERE pokeSet = ?";
	private final String GET_POKEMON_BY_ID = "SELECT * FROM pokemon WHERE id = ?";
	private final String GET_ALL_POKEMON = "SELECT * FROM pokemon";
	private final String INSERT_POKEMON = "INSERT INTO pokemon (name, type, pokeSet) VALUES (?, ?, ?)";
	private final String UPDATE_POKEMON_BY_ID = "UPDATE pokemon SET name = ?, type = ?, pokeSet = ? WHERE id = ?";
	private final String DELETE_POKEMON_BY_ID = "DELETE FROM pokemon WHERE id = ?";
	
	
	public PokemonDao() {
		connection = DBConnection.getConnection();
	}

	public List<Pokemon> getPokemonByPokeSet(int pokeSet) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POKEMON_BY_POKESET_QUERY);
		ps.setInt(1,  pokeSet);
		ResultSet rs = ps.executeQuery();
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		
		while (rs.next()) {
			pokemon.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return null;
	}
	
	public List<Pokemon> getPokemonById (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POKEMON_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		
		while (rs.next()) {
			pokemon.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return pokemon;
	}
	public List<Pokemon> getAllPokemon () throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_ALL_POKEMON);
		ResultSet rs = ps.executeQuery();
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		
		while (rs.next()) {
			pokemon.add(new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return pokemon;
	}
	
	public void createPokemon(String name, String type, int pokeSet) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(INSERT_POKEMON);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, pokeSet);
		ps.executeUpdate();
	}
	
	public void updatePokemonById (int id, String name, String type, int pokeSet) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_POKEMON_BY_ID);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, pokeSet);
		ps.setInt(4, id);
		ps.executeUpdate();
	}
	
	public void deletePokemonById (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_POKEMON_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
