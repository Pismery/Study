package com.pismery.study.structure.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;

@Slf4j
public class BSTTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void insert() {
        BST bst = new BST();
        bst.insert(1, 1);
        bst.insert(1, 1);
        bst.insert(2, 1);
        assertEquals(2, bst.length());
    }

    @Test
    public void isContain() {
        BST bst = init();
        assertTrue(bst.isContain(23));
        assertFalse(bst.isContain(43));
    }


    @Test
    public void preOrder() {
        BST bst = init();
        assertEquals(Arrays.asList(50, 29, 23, 33, 68, 63, 83), bst.preOrder());
    }

    @Test
    public void midOrder() {
        BST bst = init();
        assertEquals(Arrays.asList(23, 29, 33, 50, 63, 68, 83), bst.midOrder());
    }

    @Test
    public void postOrder() {
        BST bst = init();
        assertEquals(Arrays.asList(23, 33, 29, 63, 83, 68, 50), bst.postOrder());
    }

    @Test
    public void levelOrder() {
        BST bst = init();
        assertEquals(Arrays.asList(50, 29, 68, 23, 33, 63, 83), bst.levelOrder());
    }

    @Test
    public void minimunKey() {
        BST bst = init();
        assertEquals(23, bst.minimunKey().intValue());
    }

    @Test
    public void maxmunKey() {
        BST bst = init();
        assertEquals(83, bst.maxmunKey().intValue());
    }

    @Test
    public void minimunKey_when_empty() {
        BST bst = initEmpty();

        expectedException.expectMessage("root is null");

        bst.minimunKey();

    }

    @Test
    public void maxmunKey_when_empty() {
        BST bst = initEmpty();

        expectedException.expectMessage("root is null");

        bst.maxmunKey();
    }

    @Test
    public void removeMin() {
        BST bst = init();
        bst.removeMin();
        assertEquals(6, bst.length());
        assertEquals(29, bst.minimunKey().intValue());
    }

    @Test
    public void removeMin_when_empty() {
        BST bst = initEmpty();
        bst.removeMin();
        assertEquals(0, bst.length());
    }

    @Test
    public void removeMin_when_onlyRoot() {
        BST bst = initEmpty();
        bst.insert(50, 50);

        bst.removeMin();

        assertNull(bst.getRoot());
    }

    @Test
    public void removeMax() {
        BST bst = init();
        bst.removeMax();
        assertEquals(6, bst.length());
        assertEquals(68, bst.maxmunKey().intValue());
    }

    @Test
    public void removeMax_when_empty() {
        BST bst = initEmpty();
        bst.removeMax();
        assertEquals(0, bst.length());
    }

    @Test
    public void removeMax_when_onlyRoot() {
        BST bst = initEmpty();
        bst.insert(50, 50);

        bst.removeMax();

        assertNull(bst.getRoot());
    }

    @Test
    public void remove_root() {
        BST bst = init();

        bst.remove(50);

        assertEquals(Arrays.asList(23, 29, 33, 63, 68, 83), bst.midOrder());
        assertFalse(bst.isContain(50));
    }

    @Test
    public void remove_right_leaf() {
        BST bst = init();

        bst.remove(33);

        assertEquals(Arrays.asList(23, 29, 50, 63, 68, 83), bst.midOrder());
        assertFalse(bst.isContain(33));
    }

    @Test
    public void remove_left_leaf() {
        BST bst = init();

        bst.remove(63);

        assertEquals(Arrays.asList(23, 29, 33, 50, 68, 83), bst.midOrder());
        assertFalse(bst.isContain(63));
    }

    @Test
    public void remove_right_middle_with_full_child() {
        BST bst = init();

        bst.remove(68);

        assertEquals(Arrays.asList(23, 29, 33, 50, 63, 83), bst.midOrder());
        assertFalse(bst.isContain(68));
    }

    @Test
    public void remove_left_middle_with_full_child() {
        BST bst = init();

        bst.remove(29);

        assertEquals(Arrays.asList(23,  33, 50, 63, 68,83), bst.midOrder());
        assertFalse(bst.isContain(29));
    }

    @Test
    public void remove_middle_when_rightChild_isNull() {
        BST bst = new BST();
        bst.insert(50, 50);
        bst.insert(29, 29);
        bst.insert(68, 68);
        bst.insert(33, 33);
        bst.insert(63, 63);
        bst.insert(23, 23);


        bst.remove(68);

        assertEquals(Arrays.asList(23, 29, 33, 50, 63), bst.midOrder());
        assertFalse(bst.isContain(68));
    }

    @Test
    public void remove_middle_when_leftChild_isNull() {
        BST bst = new BST();
        bst.insert(50, 50);
        bst.insert(29, 29);
        bst.insert(68, 68);
        bst.insert(33, 33);
        bst.insert(63, 63);
        bst.insert(83, 83);


        bst.remove(29);

        assertEquals(Arrays.asList(33, 50, 63, 68, 83), bst.midOrder());
        assertFalse(bst.isContain(29));
    }

    @Test
    public void remove_when_empty() {
        BST bst = initEmpty();
        bst.remove(10);
        assertEquals(0, bst.length());
    }

    @Test
    public void remove_when_onlyRoot() {
        BST bst = initEmpty();
        bst.insert(50, 50);

        bst.remove(50);

        assertNull(bst.getRoot());
        assertFalse(bst.isContain(50));
        assertEquals(0, bst.length());
    }

    @Test
    public void getSingleChildren_Exception() {
        expectedException.expect(RuntimeException.class);
        BST bst = new BST();
        bst.insert(50, 50);
        bst.insert(29, 29);
        bst.insert(68, 68);

        bst.getSingleChildren(bst.getRootNode());

    }

    @Test
    public void getByKey() {
        BST bst = init();
        assertEquals(63, bst.getByKey(63).intValue());
    }

    @Test
    public void getByKey_when_key_no_find() {
        BST bst = init();
        assertNull(bst.getByKey(18));
    }

    @Test
    public void getByKey_when_key_isNull() {
        BST bst = init();
        assertNull(bst.getByKey(null));
    }

    @Test
    public void getRoot() {
        BST bst = init();
        assertEquals(50, bst.getRoot().intValue());
    }

    private BST initEmpty() {
        return new BST();
    }

    private BST init() {
        BST bst = new BST();
        bst.insert(50, 50);
        bst.insert(29, 29);
        bst.insert(68, 68);
        bst.insert(33, 33);
        bst.insert(63, 63);
        bst.insert(23, 23);
        bst.insert(83, 83);
        return bst;
    }
}