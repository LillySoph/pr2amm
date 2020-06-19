package pr2.uebung05;

import static pr.MakeItSimple.*;

public class Main {

	public enum Input {
		add, get, containv, containk, empty, size, clear, print, remove, rehash, stats, exit
	}

	public static void showActions() {
		println("Please enter which method would you like to perfom");
		for (Input in : Input.values()) {
			print(in + " ~ ");
		}
	}

	public static void main(String[] args) {
		println("Welcome to ADT Hash table! ");
		println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

		println("[1] Create Default Hash Table (Size: 10, Probing: Linear Probing)");
		println("[2] Create User Defined Hash Table");
		int hashTableDefinition = readInt();
		HashTable ht;
		if (hashTableDefinition == 1) {
			ht = new HashTable();
		} else {
			println("Enter the size of your hash table: ");
			int size = readInt();
			println("Enter [1] for Linear Probing or [2] for Quadratic Probing: ");
			int probing = readInt();
			if (probing == 1) {
				ht = new HashTable(size, new LinearProbing());
			} else {
				ht = new HashTable(size, new QuadraticProbing());
			}
		}

		println("Here are the list of actions:");
		println("°Add element                           -> [add]");
		println("°Get element                           -> [get]");
		println("°Check if hash table contains value    -> [containv]");
		println("°Check if hash table contains key      -> [containk]");
		println("°Check if hash table is empty          -> [empty]");
		println("°Get size                              -> [size]");
		println("°Clear hash table                      -> [clear]");
		println("°Print hash table                      -> [print]");
		println("°Remove Element                        -> [remove]");
		println("°Rehash hash table                     -> [rehash]");
		println("°Get number of collisions              -> [stats]");
		println("°Exit the menu                         -> [exit]");
		println();

		println("Which type of elements should your hash table contain? string or songs ?");
		String elementType = readString().toLowerCase();

		boolean start = true;
		while (start) {

			showActions();
			String input = readString().toLowerCase();
			Input in = Input.valueOf(input);

			switch (in) {

			case add:
				println("°Add element°");
				println("Please enter the key: ");
				String key = readString();
				if (elementType.equals("songs")) {
					println("°°° Song element°°°");
					println("Please enter the song titel: ");
					String titel = readString();
					println("Please enter the number of artists: ");
					String[] artists = new String[readInt()];
					for (int i = 0; i < readInt(); i++) {
						println("Artist : " + i);
						artists[i] = readString();
					}
					println("Please enter the album name: ");
					String album = readString();
					ht.put(new StringElement(key), new SongImplementation(titel, artists, album));
					println("Element is inserted in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				} else {
					println("°°° String element°°°");
					println("Please enter the value: ");
					String value = readString();
					ht.put(new StringElement(key), value);

					println("Element is inserted in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				}
			case get:
				println("°Get element");
				println("Please enter the key: ");
				String keyElement = readString();
				Object value = ht.get(keyElement);
				if (value == null) {
					println("Element is not in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				} else {
					println("Value is found: " + value);
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				}

			case containv:
				println("°Check if hash table contains value ");
				println("Please enter the value: ");
				String valueOfKey = readString();
				if (ht.contains(valueOfKey)) {
					println("Element is in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				} else {
					println("Element is not in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				}

			case containk:
				println("°Check if hash table contains key ");
				println("Please enter the key: ");
				String keyElementContain = readString();
				if (ht.containsKey(keyElementContain)) {
					println("Key is in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				} else {
					println("Key is not in hash table.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				}

			case empty:
				println("°Check if hash table is empty ");
				if (ht.isEmpty()) {
					println("Hash table is empty.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				} else {
					println("Hash table is not empty.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				}

			case size:
				println("°Get size ");
				println(ht.size());
				println("°°°°°°°°°°°°°°°°");
				showActions();
				break;

			case clear:
				println("°Clear hash table ");
				ht.clear();
				println("Hash table is cleared.");
				println("°°°°°°°°°°°°°°°°");
				showActions();
				break;

			case print:
				println("°Print hash table ");
				ht.printHT();
				println("°°°°°°°°°°°°°°°°");
				showActions();
				break;

			case remove:
				println("°Remove Element  ");
				print("\nEnter the key: ");
				String keyToRemove = readString();

				if (ht.remove(new StringElement(keyToRemove))) {
					println("Element is removed.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;

				} else {
					println("Element is not found.");
					println("°°°°°°°°°°°°°°°°");
					showActions();
					break;
				}

			case rehash:
				println("Rehash hash table");
				ht.reHash();
				println("Hash table is rehashed.");
				println("°°°°°°°°°°°°°°°°");
				showActions();
				break;

			case stats:
				println("°Get number of collisions ");
				println(ht.getStat());
				println("°°°°°°°°°°°°°°°°");
				showActions();
				break;

			case exit:
				println("°Exit the menu");
				println("Goodbye :-]");
				start = false;
				break;
			default:
				println("Invalid input. Try again!");
				start = false;
				break;
			}

		}
	}
}
