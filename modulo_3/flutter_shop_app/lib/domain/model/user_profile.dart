// lib/domain/model/user_profile.dart

class UserProfile {
  final int    id;
  final String username;
  final String email;
  final String firstName;
  final String lastName;
  final bool   isStaff;
  final bool   isActive;
  final String? avatarUrl;
  final String dateJoined;
  final int    numOrders;

  const UserProfile({
    required this.id,
    required this.username,
    required this.email,
    required this.firstName,
    required this.lastName,
    required this.isStaff,
    required this.isActive,
    this.avatarUrl,
    required this.dateJoined,
    required this.numOrders,
  });

  factory UserProfile.fromJson(Map<String, dynamic> j) => UserProfile(
    id:         j['id']                       as int,
    username:   j['username']                 as String,
    email:      j['email']                    as String,
    firstName:  (j['first_name']             as String?) ?? '',
    lastName:   (j['last_name']              as String?) ?? '',
    isStaff:    (j['is_staff']               as bool?) ?? false,
    isActive:   (j['is_active']              as bool?) ?? true,
    avatarUrl:  (j['avatar']                 as String?) ??
                 (j['avatar_url']            as String?),
    dateJoined: (j['date_joined']            as String?) ?? '',
    numOrders:  (j['num_orders']             as int?)    ?? 0,
  );

  String get fullName {
    final name = '${firstName.trim()} ${lastName.trim()}'.trim();
    return name.isEmpty ? username : name;
  }
}
