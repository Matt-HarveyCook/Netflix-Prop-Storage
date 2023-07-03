package netflixpropstorage;

//class that handles displaying the different JFrames
public class UImanager {
    loginPage loginPage = new loginPage();
    searchPage searchPage = new searchPage();
    propDetails propDetails = new propDetails();
    createAccount createAccount = new createAccount();
    addProp addProp = new addProp();
    addPropExisting addPropExisting = new addPropExisting();
    basketCheck basketCheck = new basketCheck();
    
    
    //to transition from the login page to the search page
    void loginToSearch (){

       loginPage.setVisible(false);
       loginPage.dispose();
       searchPage.setVisible(true);

    }
    
    //used to transition from the search page to the login page
    //excecuted when the log out button is pressed
    void searchToLogin(){
            
       loginPage.setVisible(true);
       searchPage.setVisible(false);
    
    }
    
    //transition from the login page to the create account page
    void loginToCreateAccount(){
        loginPage.setVisible(false);
        createAccount.setVisible(true);
    }
    
    //transition from the create account page to the login page
    //used once the account has been created
    void createAccountToLogin(){
        loginPage.setVisible(true);
        createAccount.setVisible(false);
    }
    
    //to move from the search page to the add prop page
    void searchToAddProp(){
        searchPage.setVisible(false);
        addProp.setVisible(true);
    }
    
    //from the add prop page to return existing prop page
    void addPropToExisting(){
        addProp.setVisible(false);
        addPropExisting.setVisible(true);
    }
    
}
