package com.majorproject.ckaa.travelwithme.services;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.majorproject.ckaa.travelwithme.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    List<GetDataAdapterr> GetDataAdapter1;
    RecyclerView.LayoutManager servicerecyclerlayoutManager;
    RecyclerView recyclerview;
    RecyclerView.Adapter serviceRecyclerAdapter;
    List<GetDataAdapterr> data = new ArrayList<>();
    // GetDataAdapter places = new GetDataAdapter();
    ProgressBar progressBar;
    public static final int SERVICE_HEADER = 0;
    public static final int SERVICE_CHILD = 1;
    public static final double birhospitalNearbyLatitude[] = {27.7046016,27.7045446,27.7092336};
    public static final double  birhospitalNearbyLongitude[] = {85.3119796,85.3161317,85.3136506};
    public static final String  birhospitalNearbyTitle[] = {"Nepal Army Hospital","Kathmandu ENT Hospital ","Grande City Clinic & Diagnostic Services Pvt. Ltd"};
    public static final double prakashpharmacyNearLatitude[] = {27.6951351,27.6954581,27.6987829};
    public static final double prakashpharmacyNearLongitude[] = {85.3058483,85.3052261,85.3053763};
    public static final String prakashpharmacyNearTitle[] = {"Shukraraj pharmacy","Chiranjibi Bhava Pharmacy","Nawa Durga Pharmacy"};
    public static final double birendrahospitalNearbyLatitude[] = {27.7111117};
    public static final double birendrahospitalNearbyLongitude[] = {85.2903488};
    public static final String birendrahospitalNearbyTitle[] = {"Kathmandu Model Hospital"};
    public static final double NationalpharmacyNearLatitude[] = {27.6903961,27.6912131};
    public static final double NationalpharmacyNearLongitude[] = {85.3324457,85.3313728};
    public static final String NationalpharmacyNearTitle[] = {"Rahul Pharmacy K & K Pathology Lab","MEDIC PHARMACY"};
    public static final double NIBbrancLatitude[] = {27.6922793,27.6825509,27.7141649};
    public static final double NTBbranceLongitude[] = {85.3139165,85.3123716,85.2955488};
    public static final String NTBbranchTitle[] = {"Tripura marg branch","Bhadrakaali Marg branch(ATM)","Gongabu branch"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerView1);
//        recyclerViewlayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        GetDataAdapter1 = new ArrayList<>();

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recyclerView.setHasFixedSize(true);

        //recyclerViewlayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(recyclerViewlayoutManager);

        getStaticData();
        ServiceRecyclerAdapter serviceRecyclerAdapter = new ServiceRecyclerAdapter(GetDataAdapter1, this);

        recyclerview.setAdapter(serviceRecyclerAdapter);

    }

    private List<GetDataAdapterr> getStaticData()
    {
        GetDataAdapterr hospital = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.hospital,"Hospitals");
        hospital.invisibleChildren = new ArrayList<>();
        hospital.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Bir Hospital","Tudikhel, Kathmandu","01-4221119, 01-4223807",27.705031,85.313439,birhospitalNearbyLatitude,birhospitalNearbyLongitude,"hospital",birhospitalNearbyTitle));
        hospital.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Birendra Army Hospital","Chhauni,Kathmandu","01-4371940, 01-4271965",27.711469,85.291377,birendrahospitalNearbyLatitude,birendrahospitalNearbyLongitude,"hospital",birendrahospitalNearbyTitle));
        hospital.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Blood Bank","Bhrikutimandap,Kathmandu","01-4225344",27.702109,85.320054,birhospitalNearbyLatitude,birhospitalNearbyLongitude,"hospital",birhospitalNearbyTitle));
        hospital.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Eye Hospital","Tripureshor,Kathmandu","01-4250691",27.693511,85.313910,birhospitalNearbyLatitude,birhospitalNearbyLongitude,"hospital",birhospitalNearbyTitle));
        hospital.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Patan Hospital","Lagankhel, Laltipur","01-5521612, 01-5521048",27.668414,85.321444,birhospitalNearbyLatitude,birhospitalNearbyLongitude,"hospital",birhospitalNearbyTitle));
        hospital.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"TU Teaching Hospital","Maharajgunj,Kathmandu","01-4412707, 01-4412808",27.736136,85.330204,birhospitalNearbyLatitude,birhospitalNearbyLongitude,"hospital",birhospitalNearbyTitle));
        GetDataAdapter1.add(hospital);


        GetDataAdapterr pharmacy = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.medical,"Medical Stores");
        pharmacy.invisibleChildren = new ArrayList<>();
        pharmacy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Prakash Pharmacia Pvt Ltd.","Teku, Kathmandu","01-4100166",27.696010,85.307219,prakashpharmacyNearLatitude,prakashpharmacyNearLongitude,"medicalstore",prakashpharmacyNearTitle));
        pharmacy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"National Homeo Pharmacy","Bhaakti Thapa Sadak, Kathmandu","01-4461256",27.691082, 85.333808,NationalpharmacyNearLatitude,NationalpharmacyNearLongitude,"medicalstore",NationalpharmacyNearTitle));
        pharmacy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Washa: Pasha:","Mangalbazar, Lalitpur","01-5533747",27.673074, 85.324240));
        pharmacy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Nanda Pharmacy.","Mahapal, Lalitpur","01-5533444",27.673708, 85.323084));
        GetDataAdapter1.add(pharmacy);


        GetDataAdapterr police = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.policestation,"Police Stations");
        police.invisibleChildren = new ArrayList<>();
        police.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"District Police Office","Kathmandu","01-4261790, 01-4261795",27.6792275,85.1563174));
        police.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"District Police Office","Lalitpur","01-5521350, 01-5521207",27.6701472,85.3109631));
        police.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"District Police Office","Bhaktapur","01-6614821, 01-6614708",27.673422, 85.428430));
        police.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Regional Police Unit Office","Hanumandhoka, Kathmandu","01-4262945, 01-4261360",27.6738282,85.277525));
        GetDataAdapter1.add(police);


        GetDataAdapterr embassy = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.embassy,"Embassy");
        embassy.invisibleChildren = new ArrayList<>();
        embassy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Chinese Embassy","Hattisar, Kathmandu","01-4411740",27.712718, 85.322531));
        embassy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Embassy of Republic of Korea","Chunni Bhairav Marg, Kathmandu","01-4270172",27.694618, 85.292887));
        embassy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Indian Embassy","Kapurdhara Marg, Kathmandu","01-4410900",27.723658, 85.316986));
        embassy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"British Embassy","Lainchaur, Kathmandu","01-4410583",27.720861, 85.317693));
        embassy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Embassy of Japan","Panipokhari, Kathmandu","01-4426680",27.727918,85.323783));
        embassy.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Australian Embassy","Bansbari, Kathmandu","01-4371678",27.741680, 85.339923));
        GetDataAdapter1.add(embassy);



        GetDataAdapterr electricity = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_HEADER,R.drawable.electricity,"Electricity Office");
        electricity.invisibleChildren = new ArrayList<>();
        electricity.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_CHILD,"Kathmandu Office","Balaju, Kathmandu","01-4350896","Baneshwor", "01-4474161","Chabahil","01-4474164",27.715029,85.319369));

        electricity.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_CHILD,"Bhaktapur Office","Bhaktapur","01-6610065", "Thimi (Old)","01-6610126", "Thimi (New)","01-6610065",27.715029,85.319369));
        electricity.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_CHILD,"Lalitpur","Lagankhel","01-5525618", "Pulchowk","01-5523061","","",27.715029,85.319369));
        GetDataAdapter1.add(electricity);



        GetDataAdapterr transportation = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.transportaion,"Transportation");
        transportation.invisibleChildren = new ArrayList<>();
        transportation.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"International Flight ServiceActivity","Kathmandu","01-4470311, 01-4472835",27.6857454,85.2895774));
        transportation.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Night Taxi ServiceActivity","Kathmandu","01-4244485, 01-4224375",26.7903558,83.380089));
        GetDataAdapter1.add(transportation);


        GetDataAdapterr bank = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_HEADER,R.drawable.bank,"Bank");
        bank.invisibleChildren = new ArrayList<>();
        bank.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_CHILD,"Nepal Investment Bank Ltd.",
                "Tripua Marg, Kathmandu","01-4259780","Gonagabu, Kathmandu","01-4365077","Ratna Park (ATM)","01-4445301",27.7117355,85.3156252,NIBbrancLatitude,NTBbranceLongitude,"bank",NTBbranchTitle));
        bank.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_CHILD,"Siddhartha Bank Ltd.",
                "Dharmapath, Kathmandu","01-4239535","Hattisar, Kathmandu","01-4442919","Mandala Marg (ATM)","Open 24 hours",27.7117355,85.3156252));
        bank.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_BANK_CHILD,"Kumari Bank Ltd.",
                "Ramshah path, Kathmandu","01-4232112","Nayasadak, Kathmandu","01-4238388","Durbarmarg, Kathmandu","01-4221314",27.7117355,85.3156252));
        GetDataAdapter1.add(bank);


        GetDataAdapterr money = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.money,"Money Exchanger");
        money.invisibleChildren = new ArrayList<>();
        money.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"New Annapurna Money Changer","Chhetrapati, Kathmandu","01-43258435",27.7121232,85.3080128));
        money.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Nepal Worldwide Money Exchanger","Kuleshwor, Kathmandu","01-4283728",27.6915038,85.2832691));
        money.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Prabhu Money Transfer","Lainchaur, Kathmandu","01-4442561",27.7172059,85.3162161));
        money.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Lalit Money Tranfer","Jawalakhel, Kathmandu","01-5535924",27.7337071,85.3111325));
        money.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"CG/Finco Western Union Money Transfer","Sanepa, Lalitpur","01-5525039",27.6781977,85.3139633));
        GetDataAdapter1.add(money);


        GetDataAdapterr travelagency = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.travel,"Travel Agency");
        travelagency.invisibleChildren = new ArrayList<>();
        travelagency.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Destination Nepal Tours and Travels Pvt. Ltd","Thamel, Kathmandu","01-4254522",27.7150689,85.3104112));
        travelagency.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Nepal Association of Tour & Travel Agents","Sama Marga, Kathmandu","01-4418661",27.7165137,85.3254083));
        travelagency.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Nepal Tour And Trekking ServiceActivity Pvt. Ltd","Leknath Marg, Kathmandu","9841016832",27.7181377,85.3082153));
        travelagency.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Zen Nepal Tours & Travels (P) Ltd.","Tridevi marg, Kathmandu","01-4436364",27.7141197,85.3116693));
        GetDataAdapter1.add(travelagency);


        GetDataAdapterr laundry = new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_HEADER,R.drawable.laundry,"Laundry");
        laundry.invisibleChildren = new ArrayList<>();
        laundry.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Neat & Clean Laundry ServiceActivity","Nayabazar, Kathmandu","01-4358359",27.7161981,85.3091228));
        laundry.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Clean Wash Laundry","Thamel, Kathmandu","01-4255258",27.7167347,85.3074152));
        laundry.invisibleChildren.add(new GetDataAdapterr(ServiceRecyclerAdapter.SERVICE_CHILD,"Spotless Dry Cleaner & Laundry ServiceActivity","Thamel, Kathmandu","01-4358359",27.6857037,85.3048983));
        GetDataAdapter1.add(laundry);
        

        return data;
    }
}
