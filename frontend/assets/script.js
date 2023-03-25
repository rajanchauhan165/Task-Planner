
// `https://tp-be-production.up.railway.app/taskplanner/sprints`

fetch('https://tp-be-production.up.railway.app/taskplanner/sprints', {
  mode: 'no-cors'
//   body: JSON.stringify({ data: 'example' })
})
  .then(response => response.json())
  .then(data => {
    // do something with the response
    console.log(data);
  })
  .catch(error => console.error(error));

