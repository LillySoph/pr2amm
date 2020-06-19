package pr2.uebung04;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

public class SongImplementation implements Song {

	private String name;
	private String[] artists;
	private String albumName;
	/**
	 * order in which the array is to be sorted (false if ascending, true if
	 * descending)
	 */
	private boolean descendingOrder;
	
	/**
	 * Constructor with boolean to set sorting order
	 * 
	 * @param name
	 * @param artists
	 * @param albumName
	 * @param descendingOrder
	 */
	public SongImplementation(String name, String[] artists, String albumName, boolean descendingOrder) {
		this.name = name;
		this.artists = artists;
		this.albumName = albumName;
		this.descendingOrder = descendingOrder;
	}

	/**
	 * Standard constructor
	 * 
	 * @param name
	 * @param artists
	 * @param albumName
	 */
	public SongImplementation(String name, String[] artists, String albumName) {
		this.name = name;
		this.artists = artists;
		this.albumName = albumName;
	}
	
	/**
	 * Compares two elements of type SongImplementation depending on their sorting order. 
	 * Descending order: returns -1 if this is bigger than o and 1 if this is smaller than o.
	 * Ascending order: returns 1 if this is bigger than o and -1 if this is smaller than o.
	 * Returns 0, if both are equal.
	 */
	@Override
	public int compareTo(Object s) {
		SongImplementation otherSong = (SongImplementation) s;
		if(this.descendingOrder == true && otherSong.descendingOrder == true) {
			return this.name.compareTo(otherSong.toString())*(-1);
		}else if (this.descendingOrder == false && otherSong.descendingOrder == false) {
			return this.name.compareTo(otherSong.toString());
		}else {
			throw new PRException("Sorting element with ascending and descending order is not possible.");
		}
	}
	
	@Override
	public boolean equals (Object s) {
		return
				this.name.equals(((SongImplementation)s).getSongName()) &&
                this.albumName.equals(((SongImplementation)s).getAlbumName()) &&
                this.artists[0].equals(((SongImplementation)s).getArtists()[0]);
	}

	@Override
	public String toString() {

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
