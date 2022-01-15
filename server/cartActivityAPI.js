const client = require('./db');
const postTestReportCartActivity = async (req,res) => {
    const payload = req.body
    try {
        await client.connect()
        console.log('initiating db connection')
        const collection = client.db('cucumber_tests_results').collection('cartActivityTests')
        await collection.insertMany(payload)
        
        res.sendStatus(201)

    } catch (error) {
        console.log(error)
         res.sendStatus(404)

    } finally {
        await client.close();
        console.log('closing db connection');
    }
}

const getTestsReportCartActivity = async (req,res) =>{
    try {
        await client.connect()
        console.log('initiating db connection');
        const collection = client.db('cucumber_tests_results').collection('cartActivityTests')
        const result = await collection.find({}).toArray();
        res.statusCode = 200
       return res.json(result)
    } catch (error) {
        console.log(error)
        res.sendStatus(403)
    } finally {
        await client.close();
        console.log('closing db connection');
    }
}

module.exports = {getTestsReportCartActivity, postTestReportCartActivity};