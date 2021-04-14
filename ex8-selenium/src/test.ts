import { resolve } from "path";
import { Driver } from "selenium-webdriver/chrome";
import { Builder, WebDriver, By, Key, until } from "selenium-webdriver";
import {
    beforeEach,
    expect,
    test,
} from "@jest/globals";
jest.setTimeout(30000);

let driver: WebDriver;

// SETUP
beforeEach (async () => {
    // Add ChromDriver to Path
    const chromeDriverDirPath = resolve(__dirname, "/geckodriver");
    process.env.PATH += ":".concat(chromeDriverDirPath);
    // Create Driver
    driver = await new Builder().forBrowser("firefox").build();

});

function delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
}

test("teste soma 2 numeros", async () => {

    await driver.get("https://duckduckgo.com/?t=lm&q=calculator&ia=calculator");
    await delay(300);
    const sumButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="+"]`));
    const twoButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="2"]`));
    const sevenButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="7"]`));
    const equalsButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="="]`));
    await delay(300);
    await twoButton.click();
    await sumButton.click();
    await sevenButton.click();
    await equalsButton.click();

    const resultField = await driver.findElement(By.id("display"));
    expect(await resultField.getText()).toBe("9");
    await driver.quit();
});


test("teste soma 2 numeros div 10", async () => {

    await driver.get("https://duckduckgo.com/?t=lm&q=calculator&ia=calculator");
    await delay(300);
    const sumButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="+"]`));
    const twoButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="2"]`));
    const sevenButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="7"]`));
    const equalsButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="="]`));
    await delay(300);
    await twoButton.click();
    await sumButton.click();
    await sevenButton.click();
    await equalsButton.click();
    const divButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="÷"]`));
    await divButton.click();
    const oneButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="1"]`));
    const zeroButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="0"]`));
    await oneButton.click();
    await zeroButton.click();
    await equalsButton.click();

    const resultField = await driver.findElement(By.id("display"));
    expect(await resultField.getText()).toBe("0.9");
    await driver.quit();
});

test("teste 2 operações, pegar resultado da ultima", async () => {

    await driver.get("https://duckduckgo.com/?t=lm&q=calculator&ia=calculator");
    await delay(300);
    const sumButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="+"]`));
    const twoButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="2"]`));
    const sevenButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="7"]`));
    const equalsButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="="]`));
    await delay(300);
    await twoButton.click();
    await sumButton.click();
    await sevenButton.click();
    await equalsButton.click();
    const minusButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="-"]`));
    await minusButton.click();
    const oneButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="1"]`));
    await oneButton.click();
    
    await equalsButton.click();

    const lastOperationFiled = await driver.findElement(By.css(`.tile__past-result.one-line`));
    expect(await lastOperationFiled.getText()).toBe("8");
    await driver.quit();
});

test("teste 3 operações, verificar que aparecem no histórico", async () => {

    await driver.get("https://duckduckgo.com/?t=lm&q=calculator&ia=calculator");
    await delay(300);
    const sumButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="+"]`));
    const twoButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="2"]`));
    const sevenButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="7"]`));
    const equalsButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="="]`));
    await delay(300);
    await twoButton.click();
    await sumButton.click();
    await sevenButton.click();
    
    await equalsButton.click();
    
    const minusButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="-"]`));
    await minusButton.click();
    const oneButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="1"]`));
    await oneButton.click();
    
    await equalsButton.click();
    
    const divButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="÷"]`));
    await divButton.click();
    const zeroButton = await driver.findElement(By.css(`.tile__ctrl__btn[value="0"]`));
    await oneButton.click();
    await zeroButton.click();

    await equalsButton.click();

    const lastOperationFiled = await driver.findElements(By.css(`.tile__past-result.one-line`));
    expect(await lastOperationFiled[0].getText()).toBe("0.8");
    expect(await lastOperationFiled[1].getText()).toBe("8");
    expect(await lastOperationFiled[2].getText()).toBe("9");

    await driver.quit();
});




    // .then(process.exit.bind(null, 0))
    // .catch((err) => (console.log(err), process.exit(1)));
