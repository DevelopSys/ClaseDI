fetch("https://dummyjson.com/products")
  .then((ok) => {
    return ok.json();
  })
  .then((ok1) => {
    ok1.products.forEach((element) => {
      console.log(element.title);
    });
  })
  .catch((fail) => {});
