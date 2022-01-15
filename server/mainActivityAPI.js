const client = require('./db');
const postTestReportMainActivity = async (req,res) => {
    const payload = req.body
    try {
        await client.connect()
        console.log('initiating db connection')
        const collection = client.db('cucumber_tests_results').collection('mainActivityTests')
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

const getTestsReportMainActivity = async (req,res) => {
    try {
        await client.connect()
        console.log('initiating db connection')
        const collection = client.db('cucumber_tests_results').collection('mainActivityTests')
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

module.exports = {getTestsReportMainActivity, postTestReportMainActivity};