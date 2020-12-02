package entity;

public class Pokemon {

	private int pokemonId;
	private String name;
	private String type;
	private int pokeSet;
	
	public Pokemon(int pokemonId, String name, String type, int pokeSet) {
		this.setPokemonId(pokemonId);
		this.setName(name);
		this.setType(type);
		this.setPokeSet(pokeSet);
	}


	public int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getPokeSet() {
		return pokeSet;
	}

	private void setPokeSet(int pokeSet) {
		this.pokeSet = pokeSet;
	}

}

