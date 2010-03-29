function update() {
  var name = dwr.util.getValue("demoName");
  EchoDwr.sayHello(name, function(data) {
  dwr.util.setValue("demoReply", data);
  });
}