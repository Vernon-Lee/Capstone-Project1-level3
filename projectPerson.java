/**
 * Store information of person that has to do the project
 */


public class projectPerson {
    // Attributes

    /**
     * person id
     */
    int personId;
    /**
     * person name
     */
    String personName;
    /**
     * person surname
     */
    String personSurname;
    /**
     * person telephone number
     */
    String personTelNum;
    /**
     * person email
     */
    String personEmail;
    /**
     * person address
     */
    String personAddress;

    /**
     * Create a string from details
     * @return string with details
     */
    public String toString() {
        String output;
        output = "Description: " + personId;
        output = output + "\nName: " + personName;
        output = output + "\nSurname: " + personSurname;
        output = output + "\nTelephone number: " + personTelNum;
        output = output + "\nEmail: " + personEmail;
        output = output + "\nAddress: " + personAddress;
        return output;
    }

    /**
     * get person id
     * @return person id
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * set person id
     * @param personId new person id
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * get person name
     * @return person name
     */
    // get name
    public String getPersonName() {
        return personName;
    }

    /**
     * set name of person
     * @param personName a new person name
     */
    // set name
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * get person surname
     * @return person surname
     */
    // get surname
    public String getPersonSurname() {
        return personSurname;
    }

    /**
     * set person surname
     * @param personSurname a new person surname
     */
    // set surname
    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    /**
     * get person telephone number
     * @return person telephone number
     */
    //get telephone number
    public String getPersonTelNum() {
        return personTelNum;
    }

    /**
     * person telephone number
     * @param personTelNum a new telephone number
     */
    // set telephone number
    public void setPersonTelNum(String personTelNum) {
        this.personTelNum = personTelNum;
    }

    /**
     * get email
     * @return email
     */
    // get email
    public String getPersonEmail() {
        return personEmail;
    }

    /**
     * set a persons email
     * @param personEmail a new email
     */
    // set email
    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    /**
     * get person address
     * @return person address
     */
    // get address
    public String getPersonAddress() {
        return personAddress;
    }

    /**
     * set person address
     * @param personAddress a new address
     */
    // set address
    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
