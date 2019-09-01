package com.adneom;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

public class Partiton {

	public <E> List<List<E>> partiton(List<E> liste, int taille) {
		checkPartitionValidity(liste, taille);
		List<List<E>> partitions = new ArrayList<>();
		if (taille >= liste.size()) {
			partitions.add(liste);
		} else {
			int partitionsSize = liste.size() / taille;
			if (liste.size() % taille != 0) {
				partitionsSize++;
			}
			for (int i = 0; i < partitionsSize; i++) {
				List<E> partition = createSubList(liste, taille, i);
				partitions.add(partition);
			}
		}
		return partitions;
	}

	/**
	 * verifier la validité des parametres de partition
	 * 
	 * @param liste  la liste a partitionner
	 * @param taille la taille de partion
	 */
	private <E> void checkPartitionValidity(List<E> liste, int taille) {

		// Verification du paramétre liste
		if (liste == null) {
			throw new IllegalArgumentException("La liste ne peut pas etre nulle");
		}

		if (liste.isEmpty()) {
			throw new IllegalArgumentException("La liste ne peut pas etre vide");
		}

		// Verification du paramétre taille
		if (taille <= 0) {
			throw new IllegalArgumentException("La taille de partition doit etre strictement positive");
		}
	}

	private static <E> List<E> createSubList(List<E> liste, int taille, int index) {
		int startIndex = index * taille;
		int endIndex = min(startIndex + taille, liste.size());
		return liste.subList(startIndex, endIndex);
	}

}
