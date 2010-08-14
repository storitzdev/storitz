/**
 * CsKioskTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.storitz.cshiftclient;

public class CsKioskTestCase extends junit.framework.TestCase {
    public CsKioskTestCase(java.lang.String name) {
        super(name);
    }

    public void testcsKioskSoapPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.storitz.cshiftclient.CsKioskLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1csKioskSoapPortGetKioskMerchandise() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getKioskMerchandise(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test2csKioskSoapPortKioskVer() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.kioskVer();
        // TBD - validate results
    }

    public void test3csKioskSoapPortGetSiteHours() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getSiteHours(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test4csKioskSoapPortGetSiteDirections() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getSiteDirections(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test5csKioskSoapPortGetSitePhones() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getSitePhones(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test6csKioskSoapPortGetSiteAddress() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getSiteAddress(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test7csKioskSoapPortGetSiteUnitData() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getSiteUnitData(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test8csKioskSoapPortCreateAccount() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.createAccount(new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test9csKioskSoapPortGetSiteList() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getSiteList(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test10csKioskSoapPortGetAvailableUnits() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getAvailableUnits(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String());
        // TBD - validate results
    }

    public void test11csKioskSoapPortGetMoveInCost() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getMoveInCost(new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test12csKioskSoapPortDoMoveIn() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.doMoveIn(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test13csKioskSoapPortUpdateTenantInfo() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.updateTenantInfo(new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test14csKioskSoapPortUpdateTenantAddress() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.updateTenantAddress(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test15csKioskSoapPortUpdateTenantPhone() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.updateTenantPhone(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test16csKioskSoapPortGetTenantAddress() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getTenantAddress(new java.lang.String(), new java.lang.String(), 0, 0);
        // TBD - validate results
    }

    public void test17csKioskSoapPortGetTenantPhone() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getTenantPhone(new java.lang.String(), new java.lang.String(), 0, 0);
        // TBD - validate results
    }

    public void test18csKioskSoapPortUpdateTenantPassword() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.updateTenantPassword(new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test19csKioskSoapPortGetAddressTypes() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getAddressTypes();
        // TBD - validate results
    }

    public void test20csKioskSoapPortGetPhoneTypes() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getPhoneTypes();
        // TBD - validate results
    }

    public void test21csKioskSoapPortListAccountUnits() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.listAccountUnits(new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test22csKioskSoapPortGetCurrentCharges() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getCurrentCharges(new java.lang.String(), new java.lang.String(), 0, 0, (short)0, 0, 0, 0);
        // TBD - validate results
    }

    public void test23csKioskSoapPortMakePayment() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.makePayment(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test24csKioskSoapPortGetPicture() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getPicture(new java.lang.String(), new java.lang.String(), (short)0, 0, new javax.xml.rpc.holders.ByteArrayHolder(new byte[0]));
        // TBD - validate results
    }

    public void test25csKioskSoapPortPictureReceived() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        binding.pictureReceived(new java.lang.String(), new java.lang.String(), (short)0, 0);
        // TBD - validate results
    }

    public void test26csKioskSoapPortUpdateAccountName() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.updateAccountName(new java.lang.String(), new java.lang.String(), 0, new java.lang.String());
        // TBD - validate results
    }

    public void test27csKioskSoapPortUpdatePicture() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.updatePicture(new java.lang.String(), new java.lang.String(), 0, (short)0, 0, new byte[0]);
        // TBD - validate results
    }

    public void test28csKioskSoapPortTenantLogin2() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.tenantLogin2(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test29csKioskSoapPortTenantLogin() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.tenantLogin(new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test30csKioskSoapPortGetInsuranceOptions() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getInsuranceOptions(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test31csKioskSoapPortGetContract() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getContract(new java.lang.String(), new java.lang.String(), 0, 0, 0, new java.lang.String(), new java.lang.String(), new javax.xml.rpc.holders.ByteArrayHolder(new byte[0]));
        // TBD - validate results
    }

    public void test32csKioskSoapPortGetMerchandiseCost() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getMerchandiseCost(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), (short)0);
        // TBD - validate results
    }

    public void test33csKioskSoapPortSellMerchandise() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.sellMerchandise(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test34csKioskSoapPortGetInsuranceCost() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getInsuranceCost(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test35csKioskSoapPortSellInsurance() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.sellInsurance(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test36csKioskSoapPortGetReservation() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getReservation(new java.lang.String(), new java.lang.String(), 0, new java.lang.String());
        // TBD - validate results
    }

    public void test37csKioskSoapPortUpdateAutoPay() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.updateAutoPay(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test38csKioskSoapPortGetAutopayInf() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getAutopayInf(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String());
        // TBD - validate results
    }

    public void test39csKioskSoapPortGetAfterMoveInPromotions() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getAfterMoveInPromotions(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String());
        // TBD - validate results
    }

    public void test40csKioskSoapPortGetPTDChangeCharges() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getPTDChangeCharges(new java.lang.String(), new java.lang.String(), 0, 0, new java.lang.String());
        // TBD - validate results
    }

    public void test41csKioskSoapPortGetMoveOutCost() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getMoveOutCost(new java.lang.String(), new java.lang.String(), 0, 0, 0);
        // TBD - validate results
    }

    public void test42csKioskSoapPortDoMoveOut() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.doMoveOut(new java.lang.String(), new java.lang.String(), 0, 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test43csKioskSoapPortGetUnitTransferCharges() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.getUnitTransferCharges(new java.lang.String(), new java.lang.String(), 0, 0, 0, 0);
        // TBD - validate results
    }

    public void test44csKioskSoapPortDoUnitTransfer() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.doUnitTransfer(new java.lang.String(), new java.lang.String(), 0, 0, 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test45csKioskSoapPortTEST() throws Exception {
        com.storitz.cshiftclient.CsKioskSoapBindingStub binding;
        try {
            binding = (com.storitz.cshiftclient.CsKioskSoapBindingStub)
                          new com.storitz.cshiftclient.CsKioskLocator().getcsKioskSoapPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.TEST();
        // TBD - validate results
    }

}
