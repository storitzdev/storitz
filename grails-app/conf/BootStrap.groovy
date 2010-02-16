class BootStrap {

     def init = { servletContext ->
       
       def roleUser = new Role( authority: 'ROLE_USER', description: 'Authenticated User').save()
       def roleAdmin = new Role( authority: 'ROLE_ADMIN', description: 'Admin user').save()

       new User( username:'admin', passwd:'fud2me', userRealName:'Administrator', enabled:true, email:'mamster@wnx.com', authorities:[ roleUser, roleAdmin ]).save(); 

       def site1 = new StorageSite( title:'Public Storage - Self Storage', address:'1606 Cotner Ave', city:'Los Angeles', state:'CA', zipcode: '90064', phone:'(800) 883-8369', url:'http://publicstorage.com', lat:'34.0482555637589', lng:'-118.446877335723', freeTruck: true, requiresInsurance: true, boxesAvailable:true, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false ).save();
       def site2 = new StorageSite( title:'Public Storage', address:'1617 Pontius Ave', city:'Los Angeles', state:'CA', zipcode: '90064', phone:'(310) 914-4572', url:'http://publicstorage.com', lat:'34.0480245162411', lng:'-118.446916184277', freeTruck: true, requiresInsurance: true, boxesAvailable:true, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false ).save();
       def site3 = new StorageSite( title:'A-1 Self Storage: Full Security', address:'11820 W. Olympic Blvd.', city:'Los Angeles', state:'CA', zipcode: '90064', phone:'(310) 571-0044', url:'http://selfstorage1.com', lat:'34.044858', lng:'-118.448436', freeTruck: false, requiresInsurance: true, boxesAvailable:true, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false ).save();
       def site4 = new StorageSite( title:'Public Storage - Self Storage', address:'1606 Cotner Ave', city:'Los Angeles', state:'CA', zipcode: '90064', phone:'(800) 883-8369', url:'http://publicstorage.com', lat:'34.0365126774481', lng:'-118.425388593827', freeTruck: true, requiresInsurance: true, boxesAvailable:true, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false ).save();
       def site5 = new StorageSite( title:'Westwood Self Storage', address:'1901 S Sepulveda Blvd', city:'Los Angeles', state:'CA', zipcode:'90025-5619', phone:'(310) 478-1901', url:'http://www.executiveselfstorage.com', lat:'34.1074181042622', lng:'-118.480301588142', freeTruck: false, requiresInsurance: false, boxesAvailable:true, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false ).save();
       def site6 = new StorageSite( title:'EZ Storage - Self Storage', address:'11471 West Pico Blvd.', city:'Los Angeles', state:'CA', zipcode:'90064', phone:'(877) 351-6029', url:'http://ezstorageonline.com', lat:'34.0340018834908', lng:'-118.441389137916', freeTruck: false, requiresInsurance: false, boxesAvailable:false, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false).save();
       def site7 = new StorageSite( title:'A-American Self Storage: West Los Angeles', address:'2300 Federal Ave.', city:'Los Angeles', state:'CA', zipcode:'90064-1406', phone:'(310) 597-4004', url:'http://aamericanselfstorage.com', lat:'34.0339469723605', lng:'-118.444585453274', freeTruck: false, requiresInsurance: false, boxesAvailable:true, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false ).save();
       def site8 = new StorageSite( title:'Storquest Self Storage', address:'2531 Sawtelle Blvd.', city:'Los Angeles', state:'CA', zipcode:'90064', phone:'(310) 817-6710', url:'http://storquest.com', lat:'34.0292128938148', lng:'-118.441494670588', freeTruck: false, requiresInsurance: false, boxesAvailable:false, isGate: true, isKeypad: true, isCamera: true, isUnitAlarmed: false  ).save();

       new SpecialOffer(site: site1, description:'Second Month $1').save();
       new SpecialOffer(site: site2, description:'Second Month 50% off').save();
       new SpecialOffer(site: site2, description:'$19.95 Moves you in').save();
       new SpecialOffer(site: site3, description:'$19.95 Moves you in').save();
       new SpecialOffer(site: site4, description:'$1 Moves you in').save();
       new SpecialOffer(site: site5, description:'4 mos. 50% off').save();
       new SpecialOffer(site: site6, description:'Second Month Free').save();
       new SpecialOffer(site: site7, description:'Second Month Free').save();
       new SpecialOffer(site: site8, description:'$19.95 Moves you in').save();

       def size5x5 = new StorageSize( description:'5 x 5', width: 5, length: 5).save();
       def size5x10 = new StorageSize( description:'5 x 10', width: 5, length: 10).save();
       def size7x10 = new StorageSize( description:'7 x 10', width: 7, length: 10).save();
       def size10x10 = new StorageSize( description:'10 x 10', width: 10, length: 10).save();
       def size10x15 = new StorageSize( description:'10 x 15', width: 10, length: 15).save();
       def size10x20 = new StorageSize( description:'10 x 20', width: 10, length: 20).save();
       def size10x25 = new StorageSize( description:'10 x 25', width: 10, length: 25).save();
       def size10x30 = new StorageSize( description:'10 x 30', width: 10, length: 30).save();

       new StorageUnit( site: site1, unitsize: size5x5, unitNumber: '1', isUpper: true, isInterior: false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 62, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size5x5, unitNumber: '2', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 69, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size5x5, unitNumber: '3', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 65, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 92, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 105, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 99, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size7x10, unitNumber: '7', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size7x10, unitNumber: '8', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 145, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size7x10, unitNumber: '9', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 149, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 149, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 190, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 185, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 209, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 255, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 229, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 249, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 305, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 275, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x25, unitNumber: '19', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 299, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x25, unitNumber: '20', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 325, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x25, unitNumber: '21', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 299, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x30, unitNumber: '22', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 365, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x30, unitNumber: '23', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 420, isAvailable: true).save();
       new StorageUnit( site: site1, unitsize: size10x30, unitNumber: '24', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 410, isAvailable: true).save();

       new StorageUnit( site: site2, unitsize: size5x5, unitNumber: '1', isUpper: true, isInterior: false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 61, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size5x5, unitNumber: '2', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 59, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size5x5, unitNumber: '3', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 57, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 82, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 101, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 88, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size7x10, unitNumber: '7', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 135, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size7x10, unitNumber: '8', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size7x10, unitNumber: '9', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 129, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 180, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 175, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 199, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 245, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 219, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 239, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 303, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 265, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x25, unitNumber: '19', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 305, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x25, unitNumber: '20', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 289, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x25, unitNumber: '21', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 289, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x30, unitNumber: '22', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 345, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x30, unitNumber: '23', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 390, isAvailable: true).save();
       new StorageUnit( site: site2, unitsize: size10x30, unitNumber: '24', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 388, isAvailable: true).save();

       new StorageUnit( site: site3, unitsize: size5x5, unitNumber: '1', isUpper: true, isInterior: false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 71, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size5x5, unitNumber: '2', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 78, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size5x5, unitNumber: '3', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 73, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 89, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 108, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 95, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size7x10, unitNumber: '7', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 136, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size7x10, unitNumber: '8', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 146, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size7x10, unitNumber: '9', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 142, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 146, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 187, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 182, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 206, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 252, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 246, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 245, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 308, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 271, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x25, unitNumber: '19', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 296, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x25, unitNumber: '20', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 312, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x25, unitNumber: '21', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 297, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x30, unitNumber: '22', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 354, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x30, unitNumber: '23', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 399, isAvailable: true).save();
       new StorageUnit( site: site3, unitsize: size10x30, unitNumber: '24', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 394, isAvailable: true).save();

       new StorageUnit( site: site4, unitsize: size5x5, unitNumber: '1', isUpper: true, isInterior: false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 62, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size5x5, unitNumber: '2', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 69, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size5x5, unitNumber: '3', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 65, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 92, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 105, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 99, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size7x10, unitNumber: '7', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size7x10, unitNumber: '8', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 145, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size7x10, unitNumber: '9', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 149, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 149, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 190, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 185, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 209, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 255, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 229, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 249, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 305, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 275, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x25, unitNumber: '19', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 299, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x25, unitNumber: '20', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 325, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x25, unitNumber: '21', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 299, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x30, unitNumber: '22', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 365, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x30, unitNumber: '23', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 420, isAvailable: true).save();
       new StorageUnit( site: site4, unitsize: size10x30, unitNumber: '24', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 410, isAvailable: true).save();

       new StorageUnit( site: site5, unitsize: size5x5, unitNumber: '1', isUpper: true, isInterior: false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 61, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size5x5, unitNumber: '2', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 59, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size5x5, unitNumber: '3', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 57, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 82, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 101, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 88, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size7x10, unitNumber: '7', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 135, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size7x10, unitNumber: '8', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size7x10, unitNumber: '9', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 129, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 180, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 175, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 199, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 245, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 219, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 239, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 303, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 265, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x25, unitNumber: '19', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 305, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x25, unitNumber: '20', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 289, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x25, unitNumber: '21', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 289, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x30, unitNumber: '22', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 345, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x30, unitNumber: '23', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 390, isAvailable: true).save();
       new StorageUnit( site: site5, unitsize: size10x30, unitNumber: '24', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 388, isAvailable: true).save();

       new StorageUnit( site: site6, unitsize: size5x5, unitNumber: '1', isUpper: true, isInterior: false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 71, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size5x5, unitNumber: '2', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 78, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size5x5, unitNumber: '3', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 73, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 89, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 108, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 95, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size7x10, unitNumber: '7', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 136, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size7x10, unitNumber: '8', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 146, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size7x10, unitNumber: '9', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 142, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 146, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 187, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 182, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 206, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 252, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 246, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 245, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 308, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 271, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x25, unitNumber: '19', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 296, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x25, unitNumber: '20', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 312, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x25, unitNumber: '21', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 297, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x30, unitNumber: '22', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 354, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x30, unitNumber: '23', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 399, isAvailable: true).save();
       new StorageUnit( site: site6, unitsize: size10x30, unitNumber: '24', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 394, isAvailable: true).save();

       new StorageUnit( site: site7, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 92, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 105, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 99, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 149, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 190, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 185, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size10x15, unitNumber: '13', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 209, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size10x15, unitNumber: '14', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 255, isAvailable: true).save();
       new StorageUnit( site: site7, unitsize: size10x15, unitNumber: '15', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 229, isAvailable: true).save();

       new StorageUnit( site: site8, unitsize: size5x5, unitNumber: '2', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 72, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size5x10, unitNumber: '4', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 82, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size5x10, unitNumber: '5', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 101, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size5x10, unitNumber: '6', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 88, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size10x10, unitNumber: '10', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 139, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size10x10, unitNumber: '11', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 180, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size10x10, unitNumber: '12', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 175, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size10x20, unitNumber: '16', isUpper: true, isInterior:false, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 239, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size10x20, unitNumber: '17', isUpper: false, isInterior: false, isAlarm: false, isDriveup: true, isSecure: false, isTempControlled: false, price: 303, isAvailable: true).save();
       new StorageUnit( site: site8, unitsize: size10x20, unitNumber: '18', isUpper: false, isInterior: true, isAlarm: false, isDriveup: false, isSecure: false, isTempControlled: false, price: 265, isAvailable: true).save();

     }

     def destroy = {
     }
} 