pragma solidity >=0.4.22 <0.6.0;

contract PaperContract {
    enum Status {
        Created,
        InEffect,
        SuccessfulTermination,
        UnsuccessfulTermination
    }

    struct Product {
        string name;
        string group;
        int256 quantity;
    }

    string seller; //contratado
    string buyer; //contratante
    string buyerAddress;
    int256 contractTotalPrice;
    Product[] products;

    Status status;

    uint256 effectiveDay;
    uint256 solicitationDay;
    uint256 dueDay;
    uint256 deliveryDay;
    uint256 paymentDay;

    bool fine = false;
    bool delivered = false;
    bool friendlyTerm = false;

    constructor(string memory _seller, string memory _buyer) public {
        seller = _seller;
        buyer = _buyer;
        contractTotalPrice = 0;
        status = Status.Created;
        solicitationDay = 0;
        deliveryDay = 0;
        paymentDay = 0;
    }

    function activate() public {
        status = Status.InEffect;
    }

    function setBuyerAddress(string memory _buyerAddress) public {
        buyerAddress = _buyerAddress;
    }

    function setEffectiveDay(uint256 _effectiveDay) public {
        effectiveDay = _effectiveDay;
    }

    function addProduct(
        string memory name,
        string memory group,
        int256 quantity
    ) public {
        Product memory product;
        product.name = name;
        product.group = group;
        product.quantity = quantity;
        products.push(product);
    }

    function setSolicitationDay(uint256 _solicitationDay) public {
        solicitationDay = _solicitationDay;
        // solicitation day + 10 so the date advances to when it should end
        dueDay = solicitationDay + 10;
    }

    function removeProduct() public {
        if (solicitationDay == dueDay)
        {
            uint256 i=products.length-1;
                if(products.length != 0)
                    delete products[i];
        }
    }

    function fulfillDelivery() public {
        delivered = true;
    }

    function setPaymentDay(uint256 p) public {
        paymentDay = p;
    }
     


      function verifyContractTermination() public {
        status = Status.UnsuccessfulTermination;
      	if (delivered && !friendlyTerm) {
            if (paymentDay <= (dueDay+30))
            {
                if (deliveryDay <= dueDay)
                    status = Status.SuccessfulTermination;
            }
      	}
      	// if (!delivered) {
      	// 	status = Status.UnsuccessfulTermination;
      	// }
      	// if (paymentDay > dueDay) {
      	// 	status = Status.UnsuccessfulTermination;
      	// }
        // if (deliveryDay > dueDay) {
        //     status = Status.UnsuccessfulTermination;
        // }
      }

    function unsuccessfulTerminate() public {
        status = Status.UnsuccessfulTermination;
    }

    function notifiesDelay(uint256 notificationDay, uint256 delay) public {
        // The seller notifies the buyer on notificationDay a delay.
        if (notificationDay <= dueDay - 2) {
            dueDay = dueDay + delay;
        }
    }

    function setDeliverDay(uint256 day) public {
        deliveryDay = day;
    }

    function friendlyTermination() public {
        friendlyTerm = true;
    }

    //GETTERS

    //view significa que nao tem transacao, nao precisa minerar (nao usa gas para executar)
    function getStatus() public view returns (Status) {
        return status;
    }

    function getBuyer() public view returns (string memory) {
        return buyer;
    }

    function getBuyerAddress() public view returns (string memory) {
        return buyerAddress;
    }

    function getEffectiveDay() public view returns (uint256) {
        return effectiveDay;
    }

    function getContractTotalPrice() public view returns (int256) {
        return contractTotalPrice;
    }

    function getProductsSize() public view returns (uint256) {
        return products.length;
    }

    function getProductGroup() public view returns (string memory) {
        if (products.length == 0)
            return "erro";
        return products[products.length-1].group;
    }

    function isDelivered() public view returns (bool) {
        return delivered;
    }

    function getProductQuantity() public view returns (int256) {
        if (products.length == 0)
            return -1;
        return products[products.length-1].quantity;
    }

    function setFine() public {
        fine = true;
    }
}
