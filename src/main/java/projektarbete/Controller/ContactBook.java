package projektarbete.Controller;



import projektarbete.Model.WorkContact;

import java.util.HashMap;

public class ContactBook {

    public static HashMap<String, WorkContact> workContactHashMap = new HashMap<>();//load json-file

    public static String searchContact(String key)  {
        String result = "If You see This Its Not Working kek";
        if(workContactHashMap.containsKey(key)) {
            result = "\n" +
                    "Firstname: " + workContactHashMap.get(key).getFirstName() + "\n" +
                    "Lastname: " + workContactHashMap.get(key).getLastName() + "\n" +
                    "Phone number private: " + workContactHashMap.get(key).getPhoneNumber() + "\n" +
                    "Phone Number Work: " + workContactHashMap.get(key).getJobPhoneNumber() + "\n" +
                    "Email-Address: " + workContactHashMap.get(key).getEmail() + "\n" +
                    "Company: " + workContactHashMap.get(key).getCompany() + "\n" +
                    "Job title: " + workContactHashMap.get(key).getTitle() + "\n";
        }
        return result;
    }

    public static void removeContact(String key)  {
        workContactHashMap.remove(key);
    }

    public static void updateContactBook(int choice, String key, String change)  {
        switch (choice) {
            case 1 : {
                workContactHashMap.get(key).setCompany(change);
                break;
            }
            case 2 : {
                workContactHashMap.get(key).setTitle(change);
                break;
            }
            case 3 : {
                workContactHashMap.get(key).setJobPhoneNumber(change);
                break;
            }
            case 4 : {
                workContactHashMap.get(key).setFirstName(change);
                break;
            }
            case 5 : {
                workContactHashMap.get(key).setLastName(change);
                break;
            }
            case 6 : {
                workContactHashMap.get(key).setPhoneNumber(change);
                break;
            }
            case 7 : {
                workContactHashMap.get(key).setEmail(change);
                break;
            }
         /*   case 8 : {  ifall vi vill ha en som man kan uppdatera allt. T.ex köra Jannis metod igen genom FX?-GUI?
                break;
            }
        */    case 9 : {
                return;
            }
        }
    }

    public static void printContactBook(){
        workContactHashMap.forEach((key, value) -> System.out.println("\n" +
                                                                        "Firstname: " + value.getFirstName() + "\n" +
                                                                        "Lastname: " + value.getLastName() + "\n" +
                                                                        "Phone number private: " + value.getPhoneNumber() + "\n" +
                                                                        "Phone Number Work: " + value.getJobPhoneNumber() + "\n" +
                                                                        "Email-Address: " + value.getEmail() + "\n" +
                                                                        "Company: " + value.getCompany() + "\n" +
                                                                        "Job title: " + value.getTitle() + "\n" ));

    }

    public static void addWorkContactToContactBook(String firstName,String lastName, String phoneNumber,
                                                   String email, String company, String title, String jobPhoneNumber){
        //initiera ny objekt workContact
        WorkContact workContact = new WorkContact(firstName,lastName,phoneNumber,email,company,title,jobPhoneNumber);
        //lägga till ny objekt till hashmappen
        workContactHashMap.put(workContact.getFirstName(),workContact);

    }
    //adding psvm for testing purpose
    public static void main(String[] args) {
        addWorkContactToContactBook("Jannis", "Mueller","12345","jannis@test.de","Senab","monkey","1223");
        addWorkContactToContactBook("Albert","Andersson","43423","alber@test.se","VetInte","VD","244234");
        addWorkContactToContactBook("Joakim","liden","0876","joakim@test.com","DontKnow","teamleader","44234");
        addWorkContactToContactBook("Casper","ckokealot","93837","ckokealot@choke.se","Hell Production","stagehand","8765453");
    }
}

