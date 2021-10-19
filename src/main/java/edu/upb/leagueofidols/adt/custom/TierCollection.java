/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.adt.custom;

import edu.upb.leagueofidols.adt.custom.CustomEntry;
import edu.upb.leagueofidols.adt.tree.ITree;
import edu.upb.leagueofidols.adt.custom.ICustomCollection;
import edu.upb.leagueofidols.adt.tree.PlayerTree;
import edu.upb.leagueofidols.models.Player;
import edu.upb.leagueofidols.models.TierLevel;

import java.nio.file.Path;
import java.util.Iterator;

/**
 *
 * @author cahuc
 */
public class TierCollection implements ICustomCollection<TierLevel, Player>{

    private CustomEntry<TierLevel, PlayerTree> head;

    @Override
    public void put(TierLevel key, Player value) {

        Iterator iter = this.iterator();

        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            if(current.getKey().equals(key))
            {
                current.getValue().add(value);
            }
        }

    }
    @Override
    public Player findInKey(TierLevel key, Player value) {

        Player rta= null;


        Iterator iter = this.iterator();
        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            if(current.getKey().equals(key))
            {
                if(current.getValue().contains(value))
                {
                    rta=value;
                }
            }
        }
        current =  (CustomEntry) iter.next(); 
        if(current.getKey().equals(key))
        {
            if(current.getValue().contains(value))
            {
                rta=value;
            }
        }
        return rta;

    }
    
     @Override
    public boolean existInKey(TierLevel key, Player value) {

        Iterator iter = this.iterator();
        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            if(current.getKey().equals(key))
            {
                if(current.getValue().contains(value))
                {
                    return true;
                }
            }
        }
        current =  (CustomEntry) iter.next(); 
        if(current.getKey().equals(key))
        {
            if(current.getValue().contains(value))
            {
                return true;
            }
        }
        return false;

    }


    @Override
    public Player findInAnyKey(Player value) {
                Player rta= null;


        Iterator iter = this.iterator();
        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            if(current.getValue().contains(value))
            {
              rta = value;
            }
        }
        current =  (CustomEntry) iter.next(); 
        if(current.getValue().contains(value))
        {
            rta = value;
        }
        
        return rta;
    }

    @Override
    public TierLevel findKey(Player value) {
        TierLevel rta= null;


        Iterator iter = this.iterator();
        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            if(current.getValue().contains(value))
            {
              //rta = value;
            }
        }
        return rta;
    }

    
    @Override
    public boolean existInAnyKey(Player value) {
        return false;
    }

    @Override
    public void printByKey(TierLevel key) {

    }

    @Override
    public void printAll() {

    }

    @Override
    public Iterator<PlayerTree> iterator() {
        return new TierCollectionIterator(head);
    }

    private class TierCollectionIterator implements Iterator<PlayerTree> {

        private CustomEntry<TierLevel, PlayerTree> current;

        private TierCollectionIterator(CustomEntry<TierLevel, PlayerTree> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current.getNext()!=null;
        }

        @Override
        public PlayerTree next() {
            PlayerTree element = current.getValue();
            current=current.getNext();
            return element;
        }
    }


}
