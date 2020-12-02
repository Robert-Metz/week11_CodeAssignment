package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import entity.Pokemon;
import dao.PokemonDao;

public class Menu {
	
	PokemonDao pokemonDao = new PokemonDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
													"Create Pokemon", 
													"Display All Pokemon", 
													"Display Pokemon By ID", 
													"Update Pokemon",  
													"Delete Pokemon");
	public void start() {
		String selection ="";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					createPokemon();
				} else if (selection.equals("2")) {
					displayAllPokemon();
				} else if (selection.equals("3")) {
					displayPokemon();
				} else if (selection.equals("4")) {
					updatePokemon();
				} else if (selection.equals("5")) {
					deletePokemon();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}


	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
		
	}

	private void createPokemon() throws SQLException {
		System.out.println("Enter New Pokemon Name: ");
		String pokeName = scanner.nextLine();
		System.out.println("Enter New Pokemon Type: ");
		String pokeType = scanner.nextLine();
		System.out.println("Enter New Pokemon Set Number: ");
		int pokeSet = Integer.parseInt(scanner.nextLine());
		pokemonDao.createPokemon(pokeName, pokeType, pokeSet);
	}
	private void displayAllPokemon() throws SQLException {
		List <Pokemon> poke = pokemonDao.getAllPokemon();
		for (Pokemon pokemon : poke)
		System.out.println("\t - Pokemon ID: " + pokemon.getPokemonId() + "\n\t - Name: " + pokemon.getName() + "\n\t - Type: " + pokemon.getType() + "\n\t - Set Number: " + pokemon.getPokeSet() + "\n");
		
	}
	private void displayPokemon() throws SQLException {
			String selection = "";
			System.out.println("Type in Pokemon ID: ");
			selection = scanner.nextLine();
			int id = Integer.parseInt(selection);
			List <Pokemon> poke = pokemonDao.getPokemonById(id);
			for (Pokemon pokemon : poke)
			System.out.println("\t - Pokemon ID: " + pokemon.getPokemonId() + "\n\t - Name: " + pokemon.getName() + "\n\t - Type: " + pokemon.getType() + "\n\t - Set Number: " + pokemon.getPokeSet());
	}

	private void updatePokemon() throws SQLException {
		System.out.println("Enter ID Of Pokemon You'd Like To Update:  ");
		int pokeId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Updated Pokemon Name: ");
		String pokeName = scanner.nextLine();
		System.out.println("Enter Updated Pokemon Type: ");
		String pokeType = scanner.nextLine();
		System.out.println("Enter Updated Pokemon Set Number: ");
		int pokeSet = Integer.parseInt(scanner.nextLine());
		pokemonDao.updatePokemonById(pokeId ,pokeName, pokeType, pokeSet);
		
	}

	private void deletePokemon() throws SQLException {
		String selection = "";
		System.out.println("Type in Pokemon ID You Wish To Delete: ");
		selection = scanner.nextLine();
		int id = Integer.parseInt(selection);
		pokemonDao.deletePokemonById(id);
	}


	

	
	
	
}
