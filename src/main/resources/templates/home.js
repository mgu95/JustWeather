//replace to popup
const city = "Wroclaw";
const now = new Date();

updateCurrentConditions();
updateHourlyForecast();



async function updateHourlyForecast() {
    const astronomy = await getDataWithoutTime("astronomy", now);
    hourlyTemperatureRow.innerHTML = "";
    for(let i = 0; i <= 23; i++) {
        if (i.toString().length == 1) {
            const temperature = await getData("temperature", now, `0${i}`);
            hourlyTemperatureRow.insertAdjacentHTML("beforeend", `<td>${temperature} °C</td>`);
            const condition = await getData("condition", now, `0${i}`);
            const iconUrl = getConditionIconUrl(condition, astronomy.sunset, astronomy.sunrise);
            console.log(`condition=${condition}, iconUrl=${iconUrl}`)
        } else {
            const temperature = await getData("temperature", now, i);
            hourlyTemperatureRow.insertAdjacentHTML("beforeend", `<td>${temperature} °C</td>`);
        }
    }
}

function getConditionIconUrl(condition, sunset, sunrise) {
    console.log(isDay(sunset, sunrise));
    
    
    const day = "Sobota";
switch (day) {
    case "Poniedziałek":
        //console.log("Dziś jest poniedziałek.");
        break;
    // wtorek, środa, czwartek,
    case "Piątek":
        //console.log("Dziś jest piątek.");
        break;
    case "Sobota":
    case "Niedziela":
        //console.log("Weekend!");
        break;
    default:
        //console.log(`Nie ma takiego dnia tygodnia jak ${day}!`);
}
}

function isDay(sunset, sunrise) {
    console.log(`sunset=${sunset}, sunrise=${sunrise}`)
    const birthday = new Date(1995, 2, 12, 0, 0, 0);
    console.log(birthday);
}

async function updateCurrentConditions() {
    const temperature = await getData("temperature", now, now.getHours());
    const condition = await getData("condition", now, now.getHours());
    const minTemp = await getDataWithoutTime("minTemperature", now);
    const maxTemp = await getDataWithoutTime("maxTemperature", now);
    currentCity.innerHTML = city;
    currentTemperature.innerHTML = `${temperature} °C`;
    currentCondition.innerHTML = condition;
    currentMinMax.innerHTML = `Between ${minTemp} °C and ${maxTemp} °C`;
}

async function getData(type, date, hour) {
    const dateTime = dateToString(date).concat(hour.toString());
    let data = await fetch(`http://localhost:8080/weather/${type}?city=${city}&dateTime=${dateTime}`);
    let response;
    try {
        response = await data.json();
    } catch (error) {
        data = await fetch(`http://localhost:8080/weather/${type}?city=${city}&dateTime=${dateTime}`);
        response = await data.text();
    }
    return response;
}

async function getDataWithoutTime(type, date) {
    const dateTime = dateToString(date);
    let data = await fetch(`http://localhost:8080/weather/${type}?city=${city}&date=${dateTime}`);
    let response;
    try {
        response = await data.json();
    } catch (error) {
        data = await fetch(`http://localhost:8080/weather/${type}?city=${city}&dateTime=${dateTime}`);
        response = await data.text();
    }
    return response;
}

function dateToString(date) {
    const year = `${date.getFullYear()}`;
    let month;
    if (date.getMonth().toString().length == 1) {
        temp = date.getMonth();
        temp++;
        month = `0${temp}`;
    } else {
        temp = date.getMonth();
        temp++;
        month = temp;
    }
    let day;
    if (date.getDate().toString().length == 1) {
        day = `0${date.getDate()}`;
    } else {
        day = date.getDate();
    }
    return `${year}${month}${day}`;
}