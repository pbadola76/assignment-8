/**
 * Binary Search Tree 
 * Practice Assignment 8
 * @author pbadola
 **/

import java.util.*;

public class BST<T extends Comparable<T>>
{
    public Node<T> root;

    public BST()
    {
        this.root = null;
    }

    public class Node<T>
    {
        public T data;

        public Node<T> left;
        public Node<T> right;

        public Node(T item)
        {
            this.data = item;
            this.left = null;
            this.right = null;
        }
    }

    public boolean find(T item)
    {
        return find(root, item); 
    }

    private boolean find(Node<T> node, T item)
    {
       
        if(node ==  null)
        {
            return false;
        }

        if(item.compareTo(node.data) == 0) 
        {
     
            return true;
        }
       
        else if(item.compareTo(node.data) < 0)
        {
            return find(node.left, item);
        }
        else 
        {
            return find(node.right, item);
        }
    }

    public void insert(T item) 
    {
        root = insert(this.root, item); 
    }

    private Node<T> insert(Node<T> node, T item)
    {
       
        if(node == null)
        {
            return new Node<T>(item);
        }
        
        if(item.compareTo(node.data) < 0)
        {
            node.left = insert(node.left, item);
            return node;
        }
        else if(item.compareTo(node.data) > 0)
        {
            node.right = insert(node.right, item);
            return node;
        }
        else 
        {
            return node;
        }
    }

    public void delete(T item)
    {
        root = delete(this.root, item); 
    }

    private Node<T> delete(Node<T> node, T item)
    {
     
        if(node == null)
        {
   
            return node;
        }
       
        if(item.compareTo(node.data) > 0)
        {
            node.right = delete(node.right, item);
            return node;
        }
        else if(item.compareTo(node.data) < 0)
        {
            node.left = delete(node.left, item);
            return node;
        }
        else 
        {
           
            if(node.left == null)
            {
                return node.right;
            }
            else if(node.right == null)
            {
                return node.left;
            }
            else 
            {
               
                if(node.right.left == null)
                {
                    node.data = node.right.data;
                    node.right = node.right.right;
                }
                else 
                {
                    Node<T> small = removeSmallest(node);
                    node = small;
                    node = delete(node.right, item);
                }
            }
            return node;
        }
    }

    public void print()
    {
        print(this.root);
    }

    private void print(Node node)
    {
        if(node != null)
        {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    public Node<T> removeSmallest(Node<T> root)
    {
        if(root.left != null)
        {
            root = root.left;
        }
        return root;
    }
}
