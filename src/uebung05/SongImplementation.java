package pr2.uebung05;

public class SongImplementation implements Song {

	private String name;
	private String[] artists;
	private String albumName;
	
	public SongImplementation(String name, String[] artists, String albumName) {
		this.name = name;
		this.artists = artists;
		this.albumName = albumName;
	}

	@Override
	public int compareTo(Song o) {
		if(o == null)
			return 1;
		if(!(o instanceof SongImplementation))
			return 1;
		if(this.name.compareTo(o.getSongName()) != 0)
			return 1;
		if(this.albumName.compareTo(o.getAlbumName()) != 0)
			return 1;
		if(this.artists.length != o.getArtists().length)
			return 1;
		for(int i = 0; i < this.artists.length; i++) {
			if(this.artists[i].compareTo(o.getArtists()[i]) != 0)
				return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Song))
			return false;
		return(this.compareTo((Song) o) == 0);

	}
	
	@Override
	public int hashCode() {
		int hashOfArtists = this.artists[0].hashCode();
		for(int i = 1; i < this.artists.length; i++) {
			hashOfArtists *= (int) artists[i].hashCode();
		}
		return (int) this.name.hashCode() * hashOfArtists * this.albumName.hashCode();
	}
	
	@Override
	public String getSongName() {
		return name;
	}

	@Override
	public String getAlbumName() {
		return albumName;
	}

	@Override
	public String[] getArtists() {
		return artists;
	}
	
	@Override
	public String toString() {
		String artistsAsString = "";
		for(int i = 0; i < artists.length; i++) {
			artistsAsString += artists[i] + ";";
		}
		return this.name + ";" + artistsAsString + this.albumName;
	}
	
}