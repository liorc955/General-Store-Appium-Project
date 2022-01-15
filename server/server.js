const express = require('express');
const app = express();
const {
    getTestsReportMainActivity , 
    postTestReportMainActivity
} = require('./mainActivityAPI')
const {
    getTestsReportCartActivity , 
    postTestReportCartActivity
} = require('./cartActivityAPI')
const {
    getTestsReportProductsActivity , 
    postTestProductsActivity
} = require('./productsActivityAPI')
app.use(express.json())


app.post('/mainActivityTests', postTestReportMainActivity)
app.get('/mainActivityTests', getTestsReportMainActivity)

app.post('/productsActivityTests', postTestProductsActivity)
app.get('/productsActivityTests', getTestsReportProductsActivity)

app.post('/cartActivityTests', postTestReportCartActivity)
app.get('/cartActivityTests', getTestsReportCartActivity)

app.listen(4000, () => console.log("listening on port 4000"))

