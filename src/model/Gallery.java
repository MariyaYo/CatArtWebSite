package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.xml.bind.ValidationException;

import model.Photo.Genre;

public class Gallery {
	
	private String name;
	private static Gallery instance;
	private static HashMap<Photo.Genre, HashMap<String, ConcurrentSkipListSet<Photo>>> gallery;
	// Genre > tags > Photo
	private static HashMap<String, User> allUsers;
	// userName > profile

	private Gallery(String name ) {
		if (nameIsValid(name)){
			this.name = name;
		}
		this.gallery = new HashMap<>();
		this.allUsers = new HashMap<>();
	}

	private boolean nameIsValid(String name) {
		return (name != null && name.length()>2);
	}

	public synchronized static Gallery getInstance(String name) {
		if (instance == null) {
			instance = new Gallery(name);
		}
		return instance;
	}

	public static void addProfile(User p) throws ValidationException {
		if (allUsers.containsKey(p.getUsername())) {
			throw new ValidationException("A user with this username already exists");
		} else
			allUsers.put(p.getUsername(), p);
	}

	public static void deleteProfile(User p, User admin) {
		if (allUsers.containsKey(p.getUsername())) {
			if (admin.getRights().equals(User.Rights.ADMIN)) {
				allUsers.remove(p);
			}
		}
	}

	public static User getProfileByUserName(String username) {
		if (allUsers.containsKey(username)) {
			for (Iterator iterator = allUsers.entrySet().iterator(); iterator.hasNext();) {
				Entry<String, User> usename = (Entry<String, User>) iterator.next();
				if (usename.getKey().equals(username)) {
					return usename.getValue();
				}
			}
		}
		return null;
	}

	public static void addPhoto(Photo p) {
		if (!gallery.containsKey(p.getGenre())) {
			gallery.put(p.getGenre(), new HashMap<>());
		}
		for (String s : p.getTags()) {
			if (!gallery.get(p.getGenre()).containsKey(s)) {
				gallery.get(p.getGenre()).put(s, new ConcurrentSkipListSet<>());
			}
			gallery.get(p.getGenre()).get(s).add(p);
			;
		}
	}

	public static void deletePhoto(Photo p) {
		gallery.remove(p);
	}

	public static void deleteGenre(Photo.Genre g, User admin) {
		if (admin.getRights().equals(User.Rights.ADMIN)) {
			if (!gallery.containsKey(g)) {
				gallery.remove(g);
			}
		}
	}

	public static void showProfiles() {
		int count = 1;
		System.out.println("All users:");
		for (User p : allUsers.values()) {
			System.out.println("   " + count + ": " + p.getUsername());
			count++;
		}
	}

	public static void showPhoto() {
		for (Entry<Photo.Genre, HashMap<String, ConcurrentSkipListSet<Photo>>> e : gallery.entrySet()) {
			System.out.println(e.getKey() + ":");
			for (Entry<String, ConcurrentSkipListSet<Photo>> e1 : e.getValue().entrySet()) {
				System.out.println("  -" + e1.getKey() + ":");
				for (Photo e2 : e1.getValue()) {
					System.out.println("     *" + e2.getName());
					// for now
				}
			}
		}
	}

	public static  Map<Photo.Genre, HashMap <String, ConcurrentSkipListSet<Photo>>> getGallery() {
		return Collections.unmodifiableMap(Gallery.gallery);
	}	

	public static Comparator<Photo> alphabeticProfileComparator;
	public static Comparator<Photo> noCommentsComparator;
	public static Comparator<Photo> mostCommentsComparator;
	public static Comparator<Photo> mostRatingStarsComparator;	
	public static Comparator<Photo> timeOfUploadComparator;

}