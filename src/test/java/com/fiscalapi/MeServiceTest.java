package com.fiscalapi;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.CreditBalance;
import com.fiscalapi.models.MeInfo;
import com.fiscalapi.models.PersonFeatures;
import com.fiscalapi.models.PersonSeatAssignment;
import com.fiscalapi.services.FiscalApiClient;
import com.fiscalapi.services.MeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** GET /api/v4/me: la persona de la credencial con sus features y saldos, con los nombres de MeDto del back. */
class MeServiceTest {

    private static final String ME_BODY = ("{'data':{'id':'78d380fd-1b69-4e3c-8bc0-4f57737f7d5f',"
            + "'legalName':'KARLA FUENTE NOLASCO','tin':'FUNK671228PH6','email':'persona@example.com',"
            + "'tenantId':'102e5f13-e114-41dd-bea7-507fce177281','environment':'Test','isOwner':true,"
            + "'features':{'isOwner':true,'roles':['Owner'],'permissions':['Invoices.Read','Invoices.Issue'],"
            + "'denied':{'Tickets.Create':{'missingFeatures':['auto_cfdi']}},"
            + "'features':{'emision_cfdi':{'values':{}},'descarga_cfdi':{'values':{'seats':2}}},"
            + "'subscription':{'status':'active','isAvailable':true},"
            + "'seatAssignments':[{'featureCode':'descarga_cfdi','units':1,'status':'Active'}]},"
            + "'balances':[{'creditType':1,'available':7},{'creditType':2,'available':3}]},"
            + "'succeeded':true,'message':'','details':'','httpStatusCode':200}").replace('\'', '"');

    private FakeApi api;
    private MeService me;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        api.respondWith(ME_BODY);
        me = new MeService(api.httpClient(), api.settings());
    }

    @Test
    void theClientExposesTheMeService() {
        FiscalApiClient client = FiscalApiClient.create(api.settings());

        assertTrue(client.getMeService() instanceof MeService);
    }

    @Test
    void getSendsAGetToTheMePath() {
        me.get();

        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("GET", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/me", request.url);
        assertNull(request.body);
    }

    @Test
    void getReadsThePersonItsFeaturesAndBalances() {
        ApiResponse<MeInfo> response = me.get();

        assertTrue(response.isSucceeded());
        MeInfo info = response.getData();
        assertEquals("78d380fd-1b69-4e3c-8bc0-4f57737f7d5f", info.getId());
        assertEquals("KARLA FUENTE NOLASCO", info.getLegalName());
        assertEquals("FUNK671228PH6", info.getTin());
        assertEquals("persona@example.com", info.getEmail());
        assertEquals("102e5f13-e114-41dd-bea7-507fce177281", info.getTenantId());
        assertEquals("Test", info.getEnvironment());
        assertEquals(Boolean.TRUE, info.getIsOwner());

        PersonFeatures features = info.getFeatures();
        assertEquals(Boolean.TRUE, features.getIsOwner());
        assertEquals(Collections.singletonList("Owner"), features.getRoles());
        assertEquals(Arrays.asList("Invoices.Read", "Invoices.Issue"), features.getPermissions());
        assertEquals(1, features.getDenied().size());
        assertEquals(Collections.singletonList("auto_cfdi"),
                features.getDenied().get("Tickets.Create").getMissingFeatures());
        assertTrue(features.getFeatures().get("emision_cfdi").getValues().isEmpty());
        assertEquals(Integer.valueOf(2), features.getFeatures().get("descarga_cfdi").getValues().get("seats"));
        assertEquals("active", features.getSubscription().getStatus());
        assertEquals(Boolean.TRUE, features.getSubscription().getIsAvailable());
        assertEquals(1, features.getSeatAssignments().size());
        PersonSeatAssignment seat = features.getSeatAssignments().get(0);
        assertEquals("descarga_cfdi", seat.getFeatureCode());
        assertEquals(Integer.valueOf(1), seat.getUnits());
        assertEquals("Active", seat.getStatus());

        List<CreditBalance> balances = info.getBalances();
        assertEquals(2, balances.size());
        assertEquals(Integer.valueOf(1), balances.get(0).getCreditType());
        assertEquals(Integer.valueOf(7), balances.get(0).getAvailable());
        assertEquals(Integer.valueOf(2), balances.get(1).getCreditType());
        assertEquals(Integer.valueOf(3), balances.get(1).getAvailable());
    }
}
