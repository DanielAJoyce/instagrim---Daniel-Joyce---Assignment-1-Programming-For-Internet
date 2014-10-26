package uk.ac.dundee.computing.aec.instagrim.lib;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.*;

public final class Keyspaces {

    public Keyspaces() {

    }

    public static void SetUpKeySpaces(Cluster c) {
        try {
            //Add some keyspaces here
            String createkeyspace = "create keyspace if not exists instagrim  WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
            String CreatePicTable = "CREATE TABLE if not exists instagrim.pics ("
                    + " user text,"
                    + " picid uuid, "                 
                    + " interaction_time timestamp,"
                    + " title text,"
                    + " image blob,"
                    + " thumb blob,"
                    + " processed blob,"
                    + " imagelength int,"
                    + " thumblength int,"
                    + " pictags text, "
                    + " processedlength int,"
                    + " type  text,"
                    + " name  text,"
                    + " tag  text,"
                    + " PRIMARY KEY (picid)"
                    + ")";
            String Createuserpiclist = "CREATE TABLE if not exists instagrim.userpiclist (\n"
                    + "picid uuid,\n"
                    + "user text,\n"
                    + "pic_added timestamp,\n"
                    + "PRIMARY KEY (user,pic_added)\n"
                    + ") WITH CLUSTERING ORDER BY (pic_added desc);";
            String CreateAddressType = "CREATE TYPE if not exists instagrim.address (\n"
                    + "      street text,\n"
                    + "      city text,\n"
                    + "      zip int\n"
                    + "  );";
            String CreateUserProfile = "CREATE TABLE if not exists instagrim.userprofiles (\n"
                    + "      login text PRIMARY KEY,\n"
                     + "     password text,\n"
                    + "      first_name text,\n"
                    + "      picid uuid,\n"
                    + "      last_name text,\n"
                    + "      email set<text>,\n"
                    + "      gender text,\n"
                    + "      addresses  map<text, frozen <address>>\n"
                    + "  );";
            String CreateTag = "CREATE TABLE if not exists instagrim.tag (\n"
                    + "      picid uuid, \n"
                    + "      tag text,"
                    + "      PRIMARY KEY(tag,picid)"
                    + " );";
            String CreateComments = "CREATE TABLE if not exists instagrim.comment (\n"
                    + "      picid uuid, \n"
                    + "      comment text,"
                    + "      user text,"
                    + "      PRIMARY KEY (picid, comment)"
                    + " );";
            Session session = c.connect();
            try {
                PreparedStatement statement = session
                        .prepare(createkeyspace);
                BoundStatement boundStatement = new BoundStatement(
                        statement);
                ResultSet rs = session
                        .execute(boundStatement);
                System.out.println("created instagrim");
            } catch (Exception et) {
                System.out.println("Can't create instagrim " + et);
            }

            //now add some column families 
            

            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreatePicTable);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create pic table " + et);
            }
             System.out.println("" + CreatePicTable);
            
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateComments);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create comments table " + et);
            }
            System.out.println("" + CreateComments);
        
            
             try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateTag);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create tag table " + et);
            }
            System.out.println("" + CreateTag);
            
            
            try {
                SimpleStatement cqlQuery = new SimpleStatement(Createuserpiclist);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create user pic list table " + et);
            }
            System.out.println("" + Createuserpiclist);
            
            
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateAddressType);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create Address type " + et);
            }
              System.out.println("" + CreateAddressType);
            
            
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateUserProfile);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create Address Profile " + et);
            }
            System.out.println("" + CreateUserProfile);
            session.close();

        } catch (Exception et) {
            System.out.println("Other keyspace or coulm definition error" + et);
        }

    }
}
