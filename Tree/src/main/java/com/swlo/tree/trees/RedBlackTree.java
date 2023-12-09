package com.swlo.tree.trees;

import com.swlo.tree.node.RedBlackTreeNode;
import com.swlo.tree.util.PrintEnum2;

import java.util.List;

public class RedBlackTree<T extends Comparable<T>> {

    private RedBlackTreeNode<T> root;

    public RedBlackTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(RedBlackTreeNode<T> root) {
        this.root = root;
    }

    public void add(T element) {
        if (getRoot() == null) {
            setRoot(new RedBlackTreeNode<>(element));
            return;
        }

        RedBlackTreeNode<T> current = (RedBlackTreeNode<T>) getRoot();

        while (true) {
            int comparison = element.compareTo(current.getElement());
            if (comparison < 0) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(new RedBlackTreeNode<>(element, (RedBlackTreeNode<T>) current));
                    break;
                } else {
                    current = (RedBlackTreeNode<T>) current.getLeftChild();
                }
            } else if (comparison > 0) {
                if (current.getRightChild() == null) {
                    current.setRightChild(new RedBlackTreeNode<>(element, (RedBlackTreeNode<T>) current));
                    break;
                } else {
                    current = (RedBlackTreeNode<T>) current.getRightChild();
                }
            } else {
                break; // Element is equal to current element, no need to add
            }
        }
//        fixAfterInsertion(current);
    }





    public void remove(T element) {

        if (getRoot() == null) {
            return;
        }


        RedBlackTreeNode<T> current = search(element);
        RedBlackTreeNode<T> auxiliary = null;


        if (current.getLeftChild() == null && current.getRightChild() == null) {
            auxiliary = (RedBlackTreeNode<T>) current.getParent();
            if (auxiliary.getLeftChild() == (RedBlackTreeNode<T>) current) {
                auxiliary.setLeftChild(null);
            } else {
                auxiliary.setRightChild(null);
            }
        }

        if (current.getLeftChild() != null && current.getRightChild() == null) {
            auxiliary = (RedBlackTreeNode<T>) current.getParent();
            if (auxiliary.getLeftChild() == (RedBlackTreeNode<T>) current) {
                auxiliary.setLeftChild(current.getLeftChild());
                ((RedBlackTreeNode<T>) auxiliary.getLeftChild()).setParent(auxiliary);
            } else {
                auxiliary.setRightChild(current.getLeftChild());
                ((RedBlackTreeNode<T>) auxiliary.getRightChild()).setParent(auxiliary);
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() != null) {
            auxiliary = (RedBlackTreeNode<T>) current.getParent();
            if (auxiliary.getLeftChild() == (RedBlackTreeNode<T>) current) {
                auxiliary.setLeftChild(current.getRightChild());
                ((RedBlackTreeNode<T>) auxiliary.getLeftChild()).setParent(auxiliary);
            } else {
                auxiliary.setRightChild(current.getRightChild());
                ((RedBlackTreeNode<T>) auxiliary.getRightChild()).setParent(auxiliary);
            }
        }

        if (current.getLeftChild() != null && current.getRightChild() != null) {
            auxiliary = (RedBlackTreeNode<T>) current.getRightChild();
            while (auxiliary.getLeftChild() != null) {
                auxiliary = (RedBlackTreeNode<T>) auxiliary.getLeftChild();
            }
            current.setElement(auxiliary.getElement());
            if (auxiliary.getRightChild() != null) {
                auxiliary.setElement(auxiliary.getRightChild().getElement());
                auxiliary.setRightChild(null);
            } else {
                auxiliary.setParent(auxiliary.getParent());
                auxiliary.getParent().setLeftChild(null);
            }

        }

//        fixAfterDeletion(auxiliary);
    }

    public RedBlackTreeNode<T> search(T element) {

        if (getRoot() == null) {
            return null;
        }

        RedBlackTreeNode<T> current = (RedBlackTreeNode<T>) getRoot();

        while (current != null) {
            int comparison = element.compareTo(current.getElement());
            if (comparison < 0) {
                current = (RedBlackTreeNode<T>) current.getLeftChild();
            } else if (comparison > 0) {
                current = (RedBlackTreeNode<T>) current.getRightChild();
            } else {
                return current; // Element found
            }
        }

        return null; // Element not found
    }


    @SuppressWarnings("unchecked")
    public List<T> getOrdered(PrintEnum2 type) {

        return (List<T>) type.getFunction().apply(getRoot());
    }


    private int size(RedBlackTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size((RedBlackTreeNode<T>) node.getLeftChild()) + size((RedBlackTreeNode<T>) node.getRightChild());
        }


    }

    private void fixAfterInsertion(RedBlackTreeNode<T> x) {
        x.setColor(true);

        while (x != null && x != root && x.getParent().isColor()) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                RedBlackTreeNode<T> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y)) {
                    setColor(parentOf(x), false);
                    setColor(y, false);
                    setColor(parentOf(parentOf(x)), true);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), false);
                    setColor(parentOf(parentOf(x)), true);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                RedBlackTreeNode<T> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y)) {
                    setColor(parentOf(x), false);
                    setColor(y, false);
                    setColor(parentOf(parentOf(x)), true);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), false);
                    setColor(parentOf(parentOf(x)), true);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.setColor(false);
    }


    private void fixAfterDeletion(RedBlackTreeNode<T> x) {
        while (x != root && colorOf(x) == false) {
            if (x == leftOf(parentOf(x))) {
                RedBlackTreeNode<T> sib = rightOf(parentOf(x));

                if (colorOf(sib)) {
                    setColor(sib, false);
                    setColor(parentOf(x), true);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == false && colorOf(rightOf(sib)) == false) {
                    setColor(sib, true);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == false) {
                        setColor(leftOf(sib), false);
                        setColor(sib, true);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), false);
                    setColor(rightOf(sib), false);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                RedBlackTreeNode<T> sib = leftOf(parentOf(x));

                if (colorOf(sib)) {
                    setColor(sib, false);
                    setColor(parentOf(x), true);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == false && colorOf(rightOf(sib)) == false) {
                    setColor(sib, true);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == false) {
                        setColor(rightOf(sib), false);
                        setColor(sib, true);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), false);
                    setColor(leftOf(sib), false);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, false);
    }

    private RedBlackTreeNode<T> parentOf(RedBlackTreeNode<T> node) {
        return node == null ? null : node.getParent();
    }

    private RedBlackTreeNode<T> leftOf(RedBlackTreeNode<T> node) {
        return node == null ? null : (RedBlackTreeNode<T>) node.getLeftChild();
    }

    private RedBlackTreeNode<T> rightOf(RedBlackTreeNode<T> node) {
        return node == null ? null : (RedBlackTreeNode<T>) node.getRightChild();
    }

    private boolean colorOf(RedBlackTreeNode<T> node) {
        return node == null ? false : node.isColor();
    }

    private void setColor(RedBlackTreeNode<T> node, boolean color) {
        if (node != null) {
            node.setColor(color);
        }
    }

    private void rotateLeft(RedBlackTreeNode<T> node) {
        if (node.getRightChild() == null) {
            return; // Can't rotate left
        }

        RedBlackTreeNode<T> rightChild = (RedBlackTreeNode<T>) node.getRightChild();
        node.setRightChild(rightChild.getLeftChild());

        if (node.getParent() == null) {
            root = rightChild;
        } else if (node.getParent().getLeftChild() == node) {
            node.getParent().setLeftChild(rightChild);
        } else {
            node.getParent().setRightChild(rightChild);
        }

        rightChild.setLeftChild(node);
        node.setParent(rightChild);
    }

    private void rotateRight(RedBlackTreeNode<T> node) {
        if (node.getLeftChild() == null) {
            return; // Can't rotate right
        }

        RedBlackTreeNode<T> leftChild = (RedBlackTreeNode<T>) node.getLeftChild();
        node.setLeftChild(leftChild.getRightChild());

        if (node.getParent() == null) {
            root = leftChild;
        } else if (node.getParent().getRightChild() == node) {
            node.getParent().setRightChild(leftChild);
        } else {
            node.getParent().setLeftChild(leftChild);
        }

        leftChild.setRightChild(node);
        node.setParent(leftChild);
    }


}

