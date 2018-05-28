//
//SoundPool sp1,sp2,sp3;
//        int id1,id2,id3;
//        Button B1,B2;
//
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//
//        sp1 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
//        sp2 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
//        sp3 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
//
//        id1 = sp1.load(this,R.raw.s1,1);
//        id3 = sp3.load(this,R.raw.s3,1);
//
//        id2=sp2.load(Environment.getExternalStorageDirectory().getPath()+"/Music/songs/ss5.mp3",1);
//        String s = Environment.getExternalStorageDirectory().getPath()+"/Music/songs/ss5.mp3";
//
////        id2 =sp2.load(Environment.getExternalStorageDirectory().getPath()+"",1);
//
//        B1 = findViewById(R.id.S1);
//        B2 = findViewById(R.id.S2);
//        B1.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        sp1.play(id1, (float)1, (float) 1,1,-1,1);
////                sp1.autoResume();
////// -1 repeat for ever , 0 no repeat
////                sp1.setLoop(-1,-1);
//
//        }
//        });
//        B2.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
////                sp3.play(id1,(float) 0.2,(float)0.2,1,-1,1);
//        sp2.play(id2,(float)1, (float) 1,1,-1,1);
////                sp3.autoResume();
////                sp3.setLoop(-1,-1);
//
//        }
//        });
//
//
//        }
