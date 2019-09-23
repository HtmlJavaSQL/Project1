

package org.addressbook.main;

import java.util.*;
import java.util.Iterator;
import org.addressbook.storage.Contact;
import org.addressbook.storage.*;
import org.addressbook.ui.cli.menu.Menu;
import org.addressbook.ui.cli.menu.MenuAction;
import java.util.Iterator;
import static org.addressbook.textutils.TextUtils.askFor;

public class SimpleMain{

  public static void main(String[] args){

    try{
      SimpleApplication mama = new SimpleApplication();
      mama.start();
    }catch(Exception e){
      System.err.println (" An error has occured, please read the LOG-file in " +
      System.getProperty("user.home") + System.getProperty("file.separator") +
      ".address_book.log");
    }


  }

}
