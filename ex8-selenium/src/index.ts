import { resolve } from "path";
const {Builder, By, Key, until} = require('selenium-webdriver');

function delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
}

async function main() {
    // Add ChromDriver to Path
    const chromeDriverDirPath = resolve(__dirname, "/geckodriver");
    process.env.PATH += ":".concat(chromeDriverDirPath);
    // Create Driver
    const driver = await new Builder().forBrowser("firefox").build();
    // Make Actions
    try {
        await driver.get("http://www.google.com");
        await driver.findElement(By.name('q')).sendKeys('Arthur Bianco', Key.RETURN);
        await delay(300);
        await driver.wait(until.titleIs("Arthur Bianco - Pesquisa Google"), 1000);
        
    } finally {
        await driver.quit();
      }
}

main();






    // .then(process.exit.bind(null, 0))
    // .catch((err) => (console.log(err), process.exit(1)));
