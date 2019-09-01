package com.adneom;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class PartitonTest {
	
	
    private Partiton partition;

    @Before
    public void setUp() {
        this.partition = new Partiton();
    }
    
    @Test
    public void testPartitionWhenListIsNull() {
        try {
            List<Integer> list = null;
            int taille = 0;

            this.partition.partiton(list, taille);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("La liste ne peut pas etre nulle"));
        }
    }
    
    @Test
    public void testPartitionWhenListIsEmpty() {
        try {
            List<Integer> list = asList();
            int taille = 2;

            this.partition.partiton(list, taille);

        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("La liste ne peut pas etre vide"));
        }
    }
    
    @Test
    public void testPartitionWhenSizeIsStrictlyInferiorThanOne() {
        try {
            List<Integer> list = asList(1, 2, 3, 4, 5);
            int taille = 0;

            this.partition.partiton(list, taille);

        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("La taille de partition doit etre strictement positive"));
        }
    }
    
    @Test
    public void testPartitionWhenSizeIsStrictlySuperiotThanListSize() {
            List<Integer> list = asList(1, 2, 3, 4, 5);
            int taille = 6;

            List<List<Integer>> partitions = this.partition.partiton(list, taille);
            assertThat(partitions, is(asList(asList(1, 2, 3, 4, 5))));

    }
    
    @Test
    public void testPartitionpartitionWhenSizeEqual2() {
        List<Integer> list = asList(1, 2, 3, 4, 5);
        int taille = 2;

        List<List<Integer>> partitions = this.partition.partiton(list, taille);

        assertThat(partitions, is(asList(asList(1, 2), asList(3, 4), asList(5))));

    }
    
    @Test
    public void testPartitionWhenSizeEqual3() {
        List<Integer> list = asList(1, 2, 3, 4, 5);
        int taille = 3;

        List<List<Integer>> partitions = this.partition.partiton(list, taille);

        assertThat(partitions, is(asList(asList(1, 2, 3), asList(4, 5))));
    }

    @Test
    public void testPartitionpartitionWhenSizeEqual1() {
        List<Integer> list = asList(1, 2, 3, 4, 5);
        int taille = 1;

        List<List<Integer>> partitions = this.partition.partiton(list, taille);

        assertThat(partitions, is(asList(asList(1), asList(2), asList(3), asList(4), asList(5))));

    }

    

}
