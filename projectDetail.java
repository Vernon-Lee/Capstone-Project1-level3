/**
 * class for the project details
 */
public class projectDetail {
    //Attributes
    /**
     * project number
     */
    public int number;
    /**
     * project name
     */
    public String name;
    /**
     * type of building constructed
     */
    public String buildingType;
    /**
     * building address
     */
    public String address;
    /**
     * the erd number
     */
    public String ERFNumber;
    /**
     * fee charged for project
     */
    public long totFee;
    /**
     * fee paid for project
     */
    public long totPaid;
    /**
     * project start date
     */
    public String startDate;
    /**
     * project end date
     */
    public String deadline;
    /**
     * project completion status
     */
    public String complete;
    /**
     * customer id
     */
    public int customerId;
    /**
     * architect id
     */
    public int architectId;
    /**
     * contractor id
     */
    public int contractorId;
    /**
     * Create a string from details
     * @return string with details
     */
    // to string
    public String toString() {
        String output = "Project number: " + number;
        output = output + "\nProject name: " + name;
        output = output + "\nBuilding type: " + buildingType;
        output = output + "\nAddress: " + address;
        output = output + "\nERF number: " + ERFNumber;
        output = output + "\nProject fee: " + totFee;
        output = output + "\nAmount paid: " + totPaid;
        output = output + "\nProject start date: " + startDate;
        output = output + "\nProject deadline: " + deadline;
        output = output + "\nProject complete: " + complete;
        output = output + "\nCustomer id: " + customerId;
        output = output + "\nArchitect id: " + architectId;
        output = output + "\nContractor id: " + contractorId + "\n";
        return output;
    }

    /**
     * get number of project
     * @return project number
     */
    // Get number
    public int getNumber() {
        return number;
    }

    /**
     * set project number
     * @param number a new project number
     */
    // Set number
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * get project name
     * @return project name
     */
    // Get name
    public String getName() {
        return name;
    }

    /**
     * set project name
     * @param name a new project name
     */
    // Set name
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get building type
     * @return building type
     */
    // Get building type
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * set building type
     * @param buildingType a new building type
     */
    // Set building type
    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    /**
     * get address
     * @return address
     */
    // Get address
    public String getAddress() {
        return address;
    }

    /**
     * set address
     * @param address a new address
     */
    // Set address
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get ERF number
     * @return ERF number
     */
    // Get ERF number
    public String getERFNumber() {
        return ERFNumber;
    }

    /**
     * set ERF number
     * @param ERFNumber a new ERF number
     */
    // Set ERF number
    public void setERFNumber(String ERFNumber) {
        this.ERFNumber = ERFNumber;
    }

    /**
     * get total fee
     * @return total fee
     */
    // Get total fee
    public long getTotFee() {
        return totFee;
    }

    /**
     * set total fee
     * @param totFee a new total fee
     */
    // Set total fee
    public void setTotFee(long totFee) {
        this.totFee = totFee;
    }

    /**
     * total fee paid
     * @return total fee paid
     */
    // Get total fee paid
    public long getTotPaid() {
        return totPaid;
    }

    /**
     * set total fee paid
     * @param totPaid a new total fee paid
     */
    // Set total fee paid
    public void setTotPaid(long totPaid) {
        this.totPaid = totPaid;
    }

    /**
     * get start date
     * @return start date
     */
    // Get start date
    public String getStartDate() {
        return startDate;
    }

    /**
     * set start date
     * @param startDate a new start date
     */
    // Set start date
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * get deadline
     * @return deadline
     */
    // Get deadline
    public String getDeadline() {
        return deadline;
    }

    /**
     * set deadline
     * @param deadline a new deadline
     */
    // Set deadline
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * get completion status
     * @return completion status
     */
    // get complete
    public String getComplete() {
        return complete;
    }

    /**
     * set completion status
     * @param complete a new completion status
     */
    // Set complete
    public void setComplete(String complete) {
        this.complete = complete;
    }

    /**
     * get customer id
     * @return customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * set customer id
     * @param customerId new customer id
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * get architect id
     * @return architect id
     */
    public int getArchitectId() {
        return architectId;
    }

    /**
     * set architect id
     * @param architectId new architect id
     */
    public void setArchitectId(int architectId) {
        this.architectId = architectId;
    }

    /**
     * get contractor id
     * @return contractor id
     */
    public int getContractorId() {
        return contractorId;
    }

    /**
     * set contractor id
     * @param contractorId new contractor id
     */
    public void setContractorId(int contractorId) {
        this.contractorId = contractorId;
    }
}


