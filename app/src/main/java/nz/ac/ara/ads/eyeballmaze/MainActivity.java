package nz.ac.ara.ads.eyeballmaze;

import android.Manifest;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String NOTIFICATION_CHANNEL_ID = "MainChannel";
    private static final int NOTIFICATION_ID = 0; // Use a constant for notification ID
    private int count = 0; // Changed to camelCase
    private TextView showCountTextView; // Changed to camelCase

    private ActivityResultLauncher<String> requestPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showCountTextView = findViewById(R.id.show_count);

        // Initialize the ActivityResultLauncher
        requestPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        // Permission is granted. Continue the action or workflow in your app.
                        showToast("Notification permission granted");
                        // Proceed with notification-related tasks
                        fireNotification();
                    } else {
                        // Explain to the user that the feature is unavailable because the
                        // feature requires a permission that the user has denied. At the same time,
                        // respect the user's decision. Don't link to system settings in an effort
                        // to convince the user to change their decision.
                        showToast("Notification permission denied");
                        // Handle the case where the user denied the permission
                    }
                });

        createNotificationChannel();
    }

    private void requestNotificationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.POST_NOTIFICATIONS)) {
                // Show an explanation to the user *asynchronously*
                showPermissionExplanationDialog();
            } else {
                // No explanation needed, we can request the permission.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
                }
            }
        } else {
            // Permission already granted, proceed with notification
            fireNotification();
        }
    }
    private void showPermissionExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.notification_permission_needed_title) // Use string resources
                .setMessage(R.string.notification_permission_needed_message) // Use string resources
                .setPositiveButton(R.string.ok, (dialog, which) -> { // Use string resources and lambda
                    // Request the permission after the user understands
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
                    }
                })
                .setNegativeButton(R.string.cancel, null) // Use string resources
                .show();
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void showToast(View view) {
        /*
         * https://developer.android.com/guide/topics/ui/notifiers/toasts
         */
        CharSequence text = "Hello Toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this /* MainActivity */, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        playMedia();

        showSnackbar(view);

        requestNotificationPermission(); // Changed to requestNotificationPermission
    }

    private void playMedia() {
        // https://developer.android.com/guide/topics/media/mediaplayer
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.you_win_sound_effect);
        mediaPlayer.setOnCompletionListener(MediaPlayer::release); // Release resources when done
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }

    private void showSnackbar(View view) {
        /*
         * https://developer.android.com/develop/ui/views/notifications/snackbar
         */
        int duration = Snackbar.LENGTH_SHORT;
        Snackbar mySnackbar = Snackbar.make(view, R.string.snackbar_message, duration);

        mySnackbar.setAction(R.string.undo_string, v -> { // Use lambda for concise listener
            Snackbar.make(view, R.string.snackbar_restored_message, duration).show(); // Use string resources
        });
        mySnackbar.show();
    }

    // https://developer.android.com/develop/ui/views/notifications/build-notification
    private void fireNotification() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return; // Exit if permission is not granted
        }

        String notificationsExample = "Notification Title";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                        .setSmallIcon(R.drawable.abc)
                        .setContentTitle(notificationsExample)
                        .setContentText("This is a test notification body.")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Issue the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    // https://developer.android.com/develop/ui/views/notifications/channels
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final CharSequence NAME = getString(R.string.channel_name);
            final int IMPORTANCE = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel =
                    new NotificationChannel(NOTIFICATION_CHANNEL_ID, NAME, IMPORTANCE);

            // Configure the notification channel
            final String DESCRIPTION = getString(R.string.channel_description);
            notificationChannel.setDescription(DESCRIPTION);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            // Register the channel with the system. You can't change the importance
            // or other notification behaviors after this.
            NotificationManager notificationManager
                    = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void countUp(View view) {
        ++count;
        if (showCountTextView != null) {
            showCountTextView.setText(String.format(Locale.ENGLISH, "%d", count));
        }
    }
}