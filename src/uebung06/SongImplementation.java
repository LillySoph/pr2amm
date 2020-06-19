package pr2.uebung06;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

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
	public int compareTo(Object s) {
		if (!(s instanceof SongImplementation)) {
			throw new PRException("Cannot compare SongImplementation to non-SongImplementation.");
		}
		return this.name.compareTo(((SongImplementation) s).toString());
	}

	@Override
	public boolean equals(Object s) {
		if (s == null) {
			return false;
		} else if (!(s instanceof SongImplementation)) {
			return false;
		} else if (this == s) {
			return true;
		}
		return (this.compareTo((SongImplementation) s) == 0);

	}

	@Override
	public String toString() {

		// short form of output: 1 line per song
		String s = this.name + "; ";
		for (int i = 0; i < this.artists.length - 1; i++)
			s += artists[i] + ", ";
		s += this.artists[artists.length - 1] + "; ";
		s += this.albumName + "\n";
		return s;
	}

	@Override
	public String getSongName() {
		return this.name;
	}

	public String[] getArtists() {
		return this.artists;
	}

	public String getAlbumName() {
		return this.albumName;
	}
}
