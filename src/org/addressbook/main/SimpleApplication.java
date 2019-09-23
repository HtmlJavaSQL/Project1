package org.addressbook.main;

import org.addressbook.storage.*;
import org.addressbook.ui.cli.menu.Menu;
import org.addressbook.ui.cli.menu.MenuAction;
import org.addressbook.textutils.TextUtils;
import java.util.Iterator;



/**
 * This class represents the application logic of the address book.
 * It creates the menu for the application, and provides the logic
 * for each menu item.
 *
 * The idea is to allow for the main method for the application
 * to be kept short and simple, by letting main create an instance
 * of this class, and let the instance do the work of initiating
 * the menu and starting it.
 *
 * You may use this class and complete the createMenu() method
 * if you don't want to write an alternative class from scratch.
 */

public class SimpleApplication{
  private SimpleMutableList<Contact> list;
  private Menu menu = new Menu("Address book");
  /**
   * Constructs a new SimpleApplication
   * with a fresh address book loaded from file
   * if the file exists.
   */
  public SimpleApplication(){
    list = new SimpleAddressBook();
    list.load();
    System.out.println(list.numberOfEntries() +
                       " items loaded from file.");
  }

  private void createMenu(){
    menu.addMenuItem("List", new MenuAction(){
        public void onItemSelected(){
          list.listEntries();
        }
      });

    menu.addMenuItem("Add", new MenuAction(){
        public void onItemSelected(){
          String nynamn = TextUtils.askFor("What name to add for your new contact?");
          String nyepost = TextUtils.askFor("What email to add for your new contact?");
          String nytelnummer = TextUtils.askFor("What phonenumber to add for your new contact?");
          Contact conn = new Contact(nynamn, nyepost, nytelnummer);
          // conn.name = newName;
          // conn.email = newEmail;
          // conn.phone = newPhone;
          list.addEntry(conn);
          list.save();
        }
      });
  }

  /**
   * Starts this application - setting up and starting the menu system.
   */
  public void start(){
    createMenu();
    menu.start();
  }
}
