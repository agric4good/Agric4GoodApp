package com.bumie.agric4good;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavDirections;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.request_listener.NexmoConnectionListener;

public class LoginViewModel extends ViewModel {
    private NexmoClient client = NexmoClient.get();


    NavManager navManager = NavManager.getInstance();
    private MutableLiveData<NexmoConnectionListener.ConnectionStatus> _connectionStatusMutableLiveData = new MutableLiveData<>();
    public LiveData<NexmoConnectionListener.ConnectionStatus> connectionStatusLiveData = _connectionStatusMutableLiveData;

    public LoginViewModel() {
        client.setConnectionListener(new NexmoConnectionListener() {
            @Override
            public void onConnectionStatusChange(@NonNull ConnectionStatus connectionStatus, @NonNull ConnectionStatusReason connectionStatusReason) {
                if (connectionStatus == ConnectionStatus.CONNECTED) {
                    NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToChatFragment();
                    navManager.navigate(navDirections);
                    return;
                }

                _connectionStatusMutableLiveData.postValue(connectionStatus);
            }
        });
    }


    void onLoginUser(Users user) {
        if (!user.jwt.trim().isEmpty()) {
            client.login(user.jwt);
        }
    }

}