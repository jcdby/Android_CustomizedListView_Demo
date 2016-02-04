# Android_CustomizedListView_Demo
It is a simple Demo that customized the list view so that it can show a view including images,texts.
When user click one of thses views in the list view, it will prompt user by dialog. In the dialog there will be a Edit Text view showing 
the choosed item name.User can change the item in the dialog.The Changed item also will be reflected into the list view.

# Structrue of Source Code
1.There are 5 classes besides MainActivity.java. They are WifiInformation,WifiListAdapter,WifiNameModifier,WifiSecurity,WifiState, respectively.
#WifiInformation
  As mentioned at start, this is a simple one-activity app showing a list of wifi information. So, here, I abstract wifi infromation into WifiInformation class.In this class, it includs wifiName of String type, wifiState and kinOfSecurity of int type, and isBlocked of boolean type.
  wifiName shows the name of each wifi device，wifiState shows intensity of each wifi device, kindOfSecurity shows their security police, isBlocked shows if it is blocked or not.
  Also, in this class, it includes getter and setter functions.

#WifiListAdapter
  WifiListAdapter is a subclass of ArrayAdatper, that is because ArrayAdapter  is too simple to show complex views. So, here i chose to extends ArrayAdapter. 
  WifiListAdapter has a list of WifiInformation objects. The important thing is that we have to override the getView method inherited from ArrayAdapter.This method is a rendering method that is in charge of getting the souce data showing on the view, structurely.
  Each of view in the list view has a ImageView showing wifi state, a TextView showing wifi name, another TextView showing its security police, another ImageView showing if it is blocked or not.
  
#WifiNameModifier
  WifiNameModifier is a subclass of the DialogFragment. That is because the Default Dialog object can not satisfies the our needs.We need a dialog that can show each view`s wifi state image, wifi name. Also we need a dialog that can change wifi name through an EditText View.
  It has a WifiListAdapter object, a position of int, and an EditText view.
  Every Time an user clicks any view, ListView would pass the postion of that view and the data source, namely WifiListAdapter, to the DialogFragment.
  After that, the initial dialog would show the name of the clicked view item on the EditText view.Users can change the item`s name and click OK button, the data source would be updated.After that, the name of that clicked view item in list view would be updated to the new name.
#WifiSecurity and WifiState
  They are both enum class about security police information and wifi state information. In the future, i will extend the version to show different wifi state image according to its value. So does security police. 
  
