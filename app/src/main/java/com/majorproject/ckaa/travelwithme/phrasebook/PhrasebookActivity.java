package com.majorproject.ckaa.travelwithme.phrasebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.majorproject.ckaa.travelwithme.GetDataAdapter;
import com.majorproject.ckaa.travelwithme.R;

import java.util.ArrayList;
import java.util.List;

public class PhrasebookActivity extends AppCompatActivity {

    List<GetDataAdapter> GetDataAdapter1;
    RecyclerView.LayoutManager servicerecyclerlayoutManager;
    RecyclerView recyclerview;
    RecyclerView.Adapter serviceRecyclerAdapter;
    List<GetDataAdapter> data = new ArrayList<>();
    // GetDataAdapter places = new GetDataAdapter();
    ProgressBar progressBar;
    public static final int PHRASEBOOK_HEADER = 0;
    public static final int PHRASEBOOK_CHILD = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);
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
        PhrasebookRecyclerAdapter phrasebookRecyclerAdapter = new PhrasebookRecyclerAdapter(GetDataAdapter1,this);

        recyclerview.setAdapter(phrasebookRecyclerAdapter);

    }

    private List<GetDataAdapter> getStaticData()
    {
        GetDataAdapter basics = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Basics");
        basics.invisibleChildren = new ArrayList<>();
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Hello","Namaste","नमस्ते"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"How are you?","Hajur sanchai hunucha?","हजुर सन्चै हुनुहुन्छ?"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Fine, thank you.","Sanchai chu,Dhanyabaad. (San-chai-CHu)","सन्चै छु,धन्यबाद"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"What is your name?", "Hajur ko naam ke ho? (ha-jur ko na-m k ho?)","हजुरको नाम के हो?"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD," My name is ______ ."," Mero naam ______ ho. (MAY-ro na-m _____ ho)","मेरो नाम  _____ हो"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Thank you."," dhanyabaad (DHAN-naii-bat)","धन्यबाद"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Yes."," Hajur. (HA-jur) or Ho","हजुर | हो"));
        basics.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"No."," Chaina. (Chai-NA) or Haina. (Hai-Na)","छैन | हैन"));
        GetDataAdapter1.add(basics);


        GetDataAdapter problems = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Problems");
        problems.invisibleChildren = new ArrayList<>();
        problems.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Leave me alone.","Malaai eklai chodnus.","मलाई ‌‌‍‍‌एकलै छोदनुस्"));
        problems.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I'll call the police."," Ma police bolau chu.","म पुलिस बोलाउँ छु"));
        problems.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I need your help."," Malaai sahayog chaiyo.","मलाई सहयोग चाहियो"));
        problems.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"It's an emergency."," aapat paryo. (Aa-pat par-yo)","आपत पर्यो"));
        problems.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD," I'm lost."," Ma haraye. (Ma ha-ra-ye)","म हराए"));
        problems.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I'm sick."," Malaai sancho chaina. (Muh-lay sann-cho cha-ee-nah)","मलाई सन्चो छैन"));
        GetDataAdapter1.add(problems);

        GetDataAdapter numbers = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Numbers");
        numbers.invisibleChildren = new ArrayList<>();
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"1","ek (A-kh)","एक"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"2","dui (Du-ee)","दुई"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"3","tien (Tee-n)","तीन"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"4","char (Cha-r)","चार"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"5","panch (Pa-n-ch)","पाँच"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"6","chha (Cha)","छ"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"7","saat (Sa-at)","सात"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"8","aath (Aa-th)","आठ"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"9","nau (Na-u)","नौ"));
        numbers.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"10","das (Daa-ss)","दश"));
        GetDataAdapter1.add(numbers);


        GetDataAdapter time = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Time");
        time.invisibleChildren = new ArrayList<>();
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"now","ahile (aa-hee-le)","अहिले"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"later","pachi (paa-chi)","पछि"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"before","agadi (aa-gha-dee)","अघि"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"morning","bihana (bee-haa-na)","बिहान"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"afternoon","diuso (di-u-sho)","दिउसो"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"evening","beluka (be-lu-kha)","बेलुका"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"night","rati (raa-ti)","राति"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"today","aaja (aa-ja)","आज"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"yesterday","hijo (hee-jo)","हिजो"));
        time.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"tomorrow","bholi (bho-lee)","भोलि"));
        GetDataAdapter1.add(time);



        GetDataAdapter days = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Days");
        days.invisibleChildren = new ArrayList<>();
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Sunday","aaitabaar (ai-ta-bar)","आइतबार"));
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Monday","sombaar (som-bar)","सोमबार"));
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Tuesday","mangalbaar (man-girl-bar)","मंगलबार"));
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Wednesday","budhabaar (bu-dho-bar)","बुधबार"));
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Thursday","bihibaar (bee-hee-bar)","बिहिबार"));
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Friday","shukrabaar (shuk-ro-bar)","शुकबार"));
        days.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Saturday","shanibaar (sa-ni-bar)","शनिबार"));
        GetDataAdapter1.add(days);


        GetDataAdapter colours = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Colours");
        colours.invisibleChildren = new ArrayList<>();
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"black","kalo","कालो"));
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"white","seto","सेतो"));
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"gray","kharani","खरानी"));
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"red","raato","रातो"));
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"blue","nilo","निलो"));
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"yellow","pahelo","पहेलो"));
        colours.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"green","hariyo","हरियो"));
        GetDataAdapter1.add(colours);

        GetDataAdapter transportation = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Transportation");
        transportation.invisibleChildren = new ArrayList<>();
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"How much is a ticket to _____?","Ticket ko kati paisa ho _____?","टिकट पैसा कति हो?"));
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"One ticket to _____, please.","Euta ticket dinu hos _____?","एउटा टिकट दिनुस्"));
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Where does this train/bus go?","Yo gadi kahan janchha?","यो गादी कहाँ जान्छ?"));
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Where is the train/bus to _____?","Gaadi kahan pauchha _____?","गादी कहाँ पाउछ"));
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Does this train/bus stop in _____?","Yo gadi _____ ma rokchha?","यो गादी ____ मा रोक्छ?"));
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"When does the train/bus for _____ leave?","Gadi kun bela janchha _____?","गादी कुन बेला जान्छ?"));
        transportation.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"When will this train/bus arrive in _____?","Kun bela ma puginchha _____?","कुन बेलामा पुग्छ?"));
        GetDataAdapter1.add(transportation);



        GetDataAdapter direction = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Directions");
        direction.invisibleChildren = new ArrayList<>();
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"left","left (baayaa) (bye yaa)","बाँया"));
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"right","right (dayaa)(die yaa)","दाया"));
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"straight ahead","sidha (See-DAH)","सिधा"));
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"north","uttar (u-tta-rr)","उतर"));
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"south","dakshin (duck- shin)","दक्छिण"));
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"east","purba (pu-r-ba)","पूर्व"));
        direction.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"west","paschim (pos-chim)","पश्चिम"));
        GetDataAdapter1.add(direction);


        GetDataAdapter money = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Money");
        money.invisibleChildren = new ArrayList<>();
        money.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Do you accept credit cards?","Credit card chalchha?","केदिट कार्द चल्छ?"));
        money.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Can you change money for me?","Malaai khoodraa dinu hunchha ki?","मलाई खुदा दिनु हुन्छ?"));
        money.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Where can I get money changed?","Paisa kahaa saatinchha?","पैसा कहाँ सातिन्छ?"));
        money.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Can you change a traveler's check for me?","travel check linuhucnhha?","त्राभल चेक लिनुहुन्छ?"));
        money.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Where can I get a traveler's check changed?","travel check kahaa saatichha?","त्राभल चेक कहाँ सातिन्छ?"));
        money.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Where is an automatic teller machine (ATM)?","(ATM)maysin kahaa chaa? ","ए टि एम कहाँ छ?"));
        GetDataAdapter1.add(money);



        GetDataAdapter eating = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Eating");
        eating.invisibleChildren = new ArrayList<>();
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"A table for one person/two people, please.","kripaya Table ek yaa dui janaako lagi.","कृपया टेबल एक या दुई जनाको लागि"));
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I'm a vegetarian.","Ma Saahkahari Hu. (Ma- ma-SU Kan-DIE-nah)","म शाकाहरी हुँ"));
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"breakfast","nasta (na-s-ta)","नास्ता"));
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"lunch","khana","खाना"));
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"tea (meal)","chiya","चिया"));
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I want _____."," _____ chahanchhu.","____ चाहन्छु"));
        eating.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"It is delicious.","Mito chaa","मिठो छ"));
        GetDataAdapter1.add(eating);


        GetDataAdapter shopping = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Shopping");
        shopping.invisibleChildren = new ArrayList<>();
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"How much is this?","yes ko kati parchha?","यसको कति पर्छ?"));
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"That's too expensive.","yo ekdam mahango bhayo.","यो एकदम महँगो छ"));
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Would you take _____?"," _____ rupiya linus?","_____रुपैया लिनुस्"));
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I don't want it."," malaai chahidaina.","मलाई चाहिदैन"));
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"You're cheating me."," tapaai malaai chhaldai hunuhunchha.","तपाई मलाई छल्दै हुनुहुन्छ"));
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I'm not interested.","ma ichchhuk chhaina.","म इच्छुक छैन"));
        shopping.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"OK, I'll take it.","thik chha, ma yo linchhu.","ठीक छ, म यो लिन्छु"));
        GetDataAdapter1.add(shopping);


        GetDataAdapter authority = new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_HEADER,"Authority");
        authority.invisibleChildren = new ArrayList<>();
        authority.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"I haven't done anything wrong.","Maile kehi galti gareko chaina.","मैले केही गल्ती गरे छैन "));
        authority.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"It was a misunderstanding.","bujhaai maa kehi galti thiyo.","बुजाइमा केही गल्ती थियो"));
        authority.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Where are you taking me?","tapaai malaai kahaa laadai hunuhunchha?","तपाई मलाई कहाँ लादै हुनुहुन्छ?"));
        authority.invisibleChildren.add(new GetDataAdapter(PhrasebookRecyclerAdapter.PHRASEBOOK_CHILD,"Am I under arrest?","ma pakrau pareko hu?","म पक्राउमा परेको हो?"));
        GetDataAdapter1.add(authority);


        return data;
    }
}
